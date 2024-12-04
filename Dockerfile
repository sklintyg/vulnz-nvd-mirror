ARG from_image
FROM httpd:alpine

ARG from_image
ARG project_name
ARG artifact
ARG artifact_name
ARG artifact_version
ARG context_path
ARG vcs_url
ARG vcs_ref



ARG BUILD_DATE
#Should be set automaticaly from artifact.version (which is 7.0.2.x) but i cant manage. So hard-code it is
ENV BUILD_VERSION=7.0.2

ARG http_proxy
ARG https_proxy
ARG no_proxy

LABEL se.inera.from_image=${from_image}         \
      se.inera.project=${project_name}          \
      se.inera.artifact=${artifact}             \
      se.inera.artifact_name=${artifact_name}   \
      se.inera.version=${artifact_version}      \
      se.inera.context_path=${context_path}     \
      se.inera.vcs_url=${vcs_url}               \
      se.inera.vcs_ref=${vcs_ref}


LABEL authors="derhecht,stevespringett,jeremylong"
LABEL maintainer="jeremy.long@gmail.com"
LABEL name="jeremylong/vulnz"
LABEL version=$BUILD_VERSION
LABEL org.label-schema.schema-version="1.0"
LABEL org.label-schema.build-date=$BUILD_DATE
LABEL org.label-schema.name="jeremylong/vulnz"
LABEL org.label-schema.description="Persist the data using the open-vulnerability-store."
LABEL org.label-schema.url="https://github.com/jeremylong/Open-Vulnerability-Project"
LABEL org.label-schema.vcs-url="https://github.com/jeremylong/Open-Vulnerability-Project"
LABEL org.label-schema.vendor="jeremylong"
LABEL org.label-schema.version=$BUILD_VERSION
LABEL org.label-schema.docker.cmd="docker run -it --rm --name mirror -e NVD_API_KEY=YOUR_API_KEY_HERE -p 80:80 jeremylong/vulnz"

ENV user=mirror
ENV JAVA_OPT=-XX:InitialRAMPercentage=50.0 -XX:MaxRAMPercentage=80.0

RUN apk update && \
    apk add --no-cache bash openjdk17 dcron nss supervisor tzdata && \
    addgroup -S "$user" && \
    adduser -S "$user" -G "$user" && \
    addgroup "$user" www-data && \
    addgroup www-data "$user" && \
    chown -R "$user":"$user" /usr/local/apache2/htdocs && \
    mkdir -p /var/log/supervisor && \
    chown -R "$user":"$user" /var/log && \
    chown -R "$user":"$user" /usr/local/apache2 && \
    touch /var/run/supervisord.pid && \
    chown "$user":"$user" /var/run/supervisord.pid && \
    rm -v /usr/local/apache2/htdocs/index.html

COPY ["/vulnz/src/docker/supervisor/supervisord.conf", "/etc/supervisord.conf"]
COPY ["/vulnz/src/docker/scripts/mirror.sh", "/mirror.sh"]
COPY ["/vulnz/src/docker/crontab/mirror", "/etc/crontabs/mirror"]
COPY ["/vulnz/src/docker/apache/mirror.conf", "/usr/local/apache2/conf"]
COPY ["/vulnz/build/libs/vulnz-$BUILD_VERSION.jar", "/usr/local/bin/vulnz"]

RUN chmod +x /mirror.sh && \
    chown root:root /etc/crontabs/mirror && \
    chown mirror:mirror /mirror.sh && \
    chown mirror:mirror /usr/local/bin/vulnz && \
    chown mirror:mirror /etc/supervisord.conf

# ensures we can log cron task is into stdout of docker
RUN ln -sf /proc/1/fd/1 /var/log/docker_out.log

VOLUME /usr/local/apache2/htdocs
WORKDIR /usr/local/apache2/htdocs
EXPOSE 80/tcp

CMD ["/usr/bin/supervisord", "-c", "/etc/supervisord.conf"]
