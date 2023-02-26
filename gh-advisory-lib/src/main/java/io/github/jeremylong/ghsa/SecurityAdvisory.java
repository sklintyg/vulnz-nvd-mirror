/*
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * Copyright (c) 2023 Jeremy Long. All Rights Reserved.
 */
package io.github.jeremylong.ghsa;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"databaseId", "description", "ghsaId", "id", "identifiers", "notificationsPermalink", "origin",
        "permalink", "publishedAt", "references", "severity", "summary", "updatedAt", "vulnerabilities", "cvss", "cwes",
        "withdrawnAt"})
public class SecurityAdvisory {

    @JsonProperty("databaseId")
    private int databaseId;

    @JsonProperty("description")
    private String description;

    @JsonProperty("ghsaId")
    private String ghsaId;

    @JsonProperty("id")
    private String id;

    @JsonProperty("identifiers")
    private List<Identifier> identifiers;

    @JsonProperty("notificationsPermalink")
    private String notificationsPermalink;

    @JsonProperty("origin")
    private String origin;

    @JsonProperty("permalink")
    private String permalink;

    @JsonProperty("publishedAt")
    @JsonFormat(pattern = "uuuu-MM-dd'T'HH:mm:ssX", timezone = "UTC")
    private ZonedDateTime publishedAt;

    @JsonProperty("references")
    private List<Reference> references;

    @JsonProperty("severity")
    private Severity severity;

    @JsonProperty("summary")
    private String summary;

    @JsonProperty("updatedAt")
    @JsonFormat(pattern = "uuuu-MM-dd'T'HH:mm:ssX", timezone = "UTC")
    private ZonedDateTime updatedAt;

    @JsonProperty("withdrawnAt")
    @JsonFormat(pattern = "uuuu-MM-dd'T'HH:mm:ssX", timezone = "UTC")
    private ZonedDateTime withdrawnAt;

    @JsonProperty("cvss")
    private CVSS cvss;

    @JsonProperty(value = "cwes")
    private CWEs cwes;

    @JsonProperty(value = "vulnerabilities")
    private Vulnerabilities vulnerabilities;

    /**
     * Identifies the primary key from the database.
     *
     * @return the primary key from the database.
     */
    public int getDatabaseId() {
        return databaseId;
    }

    /**
     * This is a long plaintext description of the advisory
     *
     * @return the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * The GitHub Security Advisory ID
     *
     * @return the GitHub Security Advisory ID.
     */
    public String getGhsaId() {
        return ghsaId;
    }

    /**
     * The id of the advisory.
     *
     * @return the id.
     */
    public String getId() {
        return id;
    }

    /**
     * A list of identifiers for this advisory.
     *
     * @return a list of identifiers for this advisory.
     */
    @SuppressFBWarnings(value = {"EI_EXPOSE_REP",
            "EI_EXPOSE_REP2"}, justification = "I prefer to suppress these FindBugs warnings")
    public List<Identifier> getIdentifiers() {
        return identifiers;
    }

    /**
     * The permalink for the advisory's dependabot alerts page.
     *
     * @return the permalink for the advisory's dependabot alerts page.
     */
    public String getNotificationsPermalink() {
        return notificationsPermalink;
    }

    /**
     * The organization that originated the advisory.
     *
     * @return the organization that originated the advisory.
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * The permalink for the advisory.
     *
     * @return the permalink for the advisory.
     */
    public String getPermalink() {
        return permalink;
    }

    /**
     * When the advisory was published.
     *
     * @return when the advisory was published.
     */
    public ZonedDateTime getPublishedAt() {
        return publishedAt;
    }

    /**
     * A list of references for this advisory.
     *
     * @return a list of references for this advisory.
     */
    @SuppressFBWarnings(value = {"EI_EXPOSE_REP",
            "EI_EXPOSE_REP2"}, justification = "I prefer to suppress these FindBugs warnings")
    public List<Reference> getReferences() {
        return references;
    }

    /**
     * The severity of the advisory.
     *
     * @return the severity of the advisory.
     */
    public Severity getSeverity() {
        return severity;
    }

    /**
     * A short plaintext summary of the advisory.
     *
     * @return a short plaintext summary of the advisory.
     */
    public String getSummary() {
        return summary;
    }

    /**
     * When the advisory was last updated.
     *
     * @return when the advisory was last updated
     */
    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * When the advisory was withdrawn, if it has been withdrawn.
     *
     * @return when the advisory was withdrawn, if it has been withdrawn
     */
    public ZonedDateTime getWithdrawnAt() {
        return withdrawnAt;
    }

    /**
     * The CVSS associated with this advisory.
     *
     * @return the CVSS associated with this advisory.
     */
    public CVSS getCvss() {
        return cvss;
    }

    /**
     * Returns CWE Page associated with this Advisory.
     *
     * @return CWEs associated with this Advisory.
     */
    @SuppressFBWarnings(value = {"EI_EXPOSE_REP",
            "EI_EXPOSE_REP2"}, justification = "I prefer to suppress these FindBugs warnings")
    public CWEs getCwes() {
        return cwes;
    }

    /**
     * The vulnerable packages associated with the advisory.
     *
     * @return the vulnerable packages associated with the advisory.
     */
    @SuppressFBWarnings(value = {"EI_EXPOSE_REP",
            "EI_EXPOSE_REP2"}, justification = "I prefer to suppress these FindBugs warnings")
    public Vulnerabilities getVulnerabilities() {
        return vulnerabilities;
    }

    @Override
    public String toString() {
        return "SecurityAdvisory{" + "databaseId=" + databaseId + ", description='" + description + '\'' + ", ghsaId='"
                + ghsaId + '\'' + ", id='" + id + '\'' + ", identifiers=" + identifiers + ", notificationsPermalink='"
                + notificationsPermalink + '\'' + ", origin='" + origin + '\'' + ", permalink='" + permalink + '\''
                + ", publishedAt=" + publishedAt + ", references=" + references + ", severity=" + severity
                + ", summary='" + summary + '\'' + ", updatedAt=" + updatedAt + ", withdrawnAt=" + withdrawnAt
                + ", cvss=" + cvss + ", cwes=" + cwes + ", vulnerabilities=" + vulnerabilities + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SecurityAdvisory that = (SecurityAdvisory) o;
        return databaseId == that.databaseId && Objects.equals(description, that.description)
                && Objects.equals(ghsaId, that.ghsaId) && Objects.equals(id, that.id)
                && Objects.equals(identifiers, that.identifiers)
                && Objects.equals(notificationsPermalink, that.notificationsPermalink)
                && Objects.equals(origin, that.origin) && Objects.equals(permalink, that.permalink)
                && Objects.equals(publishedAt, that.publishedAt) && Objects.equals(references, that.references)
                && severity == that.severity && Objects.equals(summary, that.summary)
                && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(withdrawnAt, that.withdrawnAt)
                && Objects.equals(cvss, that.cvss) && Objects.equals(cwes, that.cwes)
                && Objects.equals(vulnerabilities, that.vulnerabilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(databaseId, description, ghsaId, id, identifiers, notificationsPermalink, origin, permalink,
                publishedAt, references, severity, summary, updatedAt, withdrawnAt, cvss, cwes, vulnerabilities);
    }
}
