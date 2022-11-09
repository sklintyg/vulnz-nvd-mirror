/*
 *  Copyright 2022 Jeremy Long
 *
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
 */
package dev.jeremylong.nvd.cli.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.jeremylong.nvd.cli.model.CveOutput;
import dev.jeremylong.nvdlib.NvdCveApi;
import dev.jeremylong.nvdlib.NvdCveApiBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.time.LocalDateTime;

@Component
@CommandLine.Command(name = "cve", description = "Client for the NVD Vulnerability API")
public class CveCommand extends AbstractNvdCommand {
    /**
     * Reference to the logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(CveCommand.class);
    @CommandLine.ArgGroup(exclusive = false)
    ModifiedRange modifiedRange;
    @CommandLine.ArgGroup(exclusive = false)
    PublishedRange publishedRange;
    @CommandLine.Option(names = {"--cpeName"}, description = "")
    private String cpeName;
    @CommandLine.Option(names = {"--cveId"}, description = "The CVE ID")
    private String cveId;
    @CommandLine.Option(names = {"--cvssV2Metrics"}, description = "")
    private String cvssV2Metrics;
    @CommandLine.Option(names = {"--cvssV3Metrics"}, description = "")
    private String cvssV3Metrics;
    @CommandLine.Option(names = {"--keywordExactMatch"}, description = "")
    private String keywordExactMatch;
    @CommandLine.Option(names = {"--keywordSearch"}, description = "")
    private String keywordSearch;
    @CommandLine.Option(names = {"--hasCertAlerts"}, description = "")
    private boolean hasCertAlerts;
    @CommandLine.Option(names = {"--hasCertNotes"}, description = "")
    private boolean hasCertNotes;
    @CommandLine.Option(names = {"--hasKev"}, description = "")
    private boolean hasKev;
    @CommandLine.Option(names = {"--hasOval"}, description = "")
    private boolean hasOval;
    @CommandLine.Option(names = {"--isVulnerable"}, description = "")
    private boolean isVulnerable;
    @CommandLine.Option(names = {"--cvssV2Severity"}, description = "")
    private NvdCveApiBuilder.CvssV2Severity cvssV2Severity;
    @CommandLine.Option(names = {"--cvssV3Severity"}, description = "")
    private NvdCveApiBuilder.CvssV3Severity cvssV3Severity;

    @Override
    public Integer call() throws Exception {
        NvdCveApiBuilder builder = NvdCveApiBuilder.aNvdCveApi()
                .withApiKey(getApiKey())
                .withDelay(getDelay());
        if (cveId != null) {
            builder.withFilter(NvdCveApiBuilder.Filter.CVE_ID, cveId);
        }
        if (cpeName != null) {
            builder.withFilter(NvdCveApiBuilder.Filter.CPE_NAME, cpeName);
        }
        if (cvssV2Metrics != null) {
            builder.withFilter(NvdCveApiBuilder.Filter.CVSS_V2_METRICS, cvssV2Metrics);
        }
        if (cvssV3Metrics != null) {
            builder.withFilter(NvdCveApiBuilder.Filter.CVSS_V3_METRICS, cvssV3Metrics);
        }
        if (keywordExactMatch != null) {
            builder.withFilter(NvdCveApiBuilder.Filter.KEYWORD_EXACT_MATCH, keywordExactMatch);
        }
        if (keywordSearch != null) {
            builder.withFilter(NvdCveApiBuilder.Filter.KEYWORD_SEARCH, keywordSearch);
        }
        if (hasCertAlerts) {
            builder.withFilter(NvdCveApiBuilder.BooleanFilter.HAS_CERT_ALERTS);
        }
        if (hasCertNotes) {
            builder.withFilter(NvdCveApiBuilder.BooleanFilter.HAS_CERT_NOTES);
        }
        if (hasKev) {
            builder.withFilter(NvdCveApiBuilder.BooleanFilter.HAS_KEV);
        }
        if (hasOval) {
            builder.withFilter(NvdCveApiBuilder.BooleanFilter.HAS_OVAL);
        }
        if (isVulnerable) {
            builder.withFilter(NvdCveApiBuilder.BooleanFilter.IS_VULNERABLE);
        }
        if (cvssV2Severity != null) {
            builder.withCvssV2SeverityFilter(cvssV2Severity);
        }
        if (cvssV3Severity != null) {
            builder.withCvssV3SeverityFilter(cvssV3Severity);
        }
        if (publishedRange != null && publishedRange.pubStartDate != null && publishedRange.pubEndDate != null) {
            builder.withPublishedDateFilter(publishedRange.pubStartDate, publishedRange.pubEndDate);
        }
        if (modifiedRange != null && modifiedRange.lastModStartDate != null) {
            LocalDateTime end = modifiedRange.lastModEndDate;
            if (end == null) {
                end = modifiedRange.lastModStartDate.minusDays(-120);
            }
            builder.withLastModifiedFilter(modifiedRange.lastModStartDate, end);
        }

        CveOutput output = new CveOutput();
        try (NvdCveApi api = builder.build()) {
            while (api.hasNext()) {
                output.addAll(api.next());
                output.setLastModifiedDate(api.getLastModifiedRequest());
            }
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(output));
            return 0;
        } catch (Exception ex) {
            LOG.error("ERROR", ex);
        }
        return 1;
    }

    static class ModifiedRange {
        @CommandLine.Option(names = "--lastModStartDate", required = true, description = "")
        LocalDateTime lastModStartDate;
        @CommandLine.Option(names = "--lastModEndDate", description = "")
        LocalDateTime lastModEndDate;
    }

    static class PublishedRange {
        @CommandLine.Option(names = "--pubStartDate", required = true)
        LocalDateTime pubStartDate;
        @CommandLine.Option(names = "--pubEndDate", required = true)
        LocalDateTime pubEndDate;
    }
}
