/*
 *  Copyright 2023 Jeremy Long
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
package io.github.jeremylong.nvdlib.nvd;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;
import java.util.UUID;

/**
 * CPE match string or range
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"vulnerable", "criteria", "matchCriteriaId", "versionStartExcluding", "versionStartIncluding",
        "versionEndExcluding", "versionEndIncluding"})
public class CpeMatch {

    /**
     * (Required)
     */
    @JsonProperty("vulnerable")
    private Boolean vulnerable;
    /**
     * (Required)
     */
    @JsonProperty("criteria")
    private String criteria;
    /**
     * (Required)
     */
    @JsonProperty("matchCriteriaId")
    private UUID matchCriteriaId;
    @JsonProperty("versionStartExcluding")
    private String versionStartExcluding;
    @JsonProperty("versionStartIncluding")
    private String versionStartIncluding;
    @JsonProperty("versionEndExcluding")
    private String versionEndExcluding;
    @JsonProperty("versionEndIncluding")
    private String versionEndIncluding;

    /**
     * (Required)
     *
     * @return vulnerable
     */
    @JsonProperty("vulnerable")
    public Boolean getVulnerable() {
        return vulnerable;
    }

    /**
     * (Required)
     *
     * @return criteria
     */
    @JsonProperty("criteria")
    public String getCriteria() {
        return criteria;
    }

    /**
     * (Required)
     *
     * @return matchCriteriaId
     */
    @JsonProperty("matchCriteriaId")
    public UUID getMatchCriteriaId() {
        return matchCriteriaId;
    }

    /**
     * @return versionStartExcluding
     */
    @JsonProperty("versionStartExcluding")
    public String getVersionStartExcluding() {
        return versionStartExcluding;
    }

    /**
     * @return versionStartIncluding
     */
    @JsonProperty("versionStartIncluding")
    public String getVersionStartIncluding() {
        return versionStartIncluding;
    }

    /**
     * @return versionStartIncluding
     */
    @JsonProperty("versionEndExcluding")
    public String getVersionEndExcluding() {
        return versionEndExcluding;
    }

    /**
     * @return versionEndIncluding
     */
    @JsonProperty("versionEndIncluding")
    public String getVersionEndIncluding() {
        return versionEndIncluding;
    }

    @Override
    public String toString() {
        return "CpeMatch{" + "vulnerable=" + vulnerable + ", criteria='" + criteria + '\'' + ", matchCriteriaId="
                + matchCriteriaId + ", versionStartExcluding='" + versionStartExcluding + '\''
                + ", versionStartIncluding='" + versionStartIncluding + '\'' + ", versionEndExcluding='"
                + versionEndExcluding + '\'' + ", versionEndIncluding='" + versionEndIncluding + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CpeMatch cpeMatch = (CpeMatch) o;
        return Objects.equals(vulnerable, cpeMatch.vulnerable) && Objects.equals(criteria, cpeMatch.criteria)
                && Objects.equals(matchCriteriaId, cpeMatch.matchCriteriaId)
                && Objects.equals(versionStartExcluding, cpeMatch.versionStartExcluding)
                && Objects.equals(versionStartIncluding, cpeMatch.versionStartIncluding)
                && Objects.equals(versionEndExcluding, cpeMatch.versionEndExcluding)
                && Objects.equals(versionEndIncluding, cpeMatch.versionEndIncluding);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vulnerable, criteria, matchCriteriaId, versionStartExcluding, versionStartIncluding,
                versionEndExcluding, versionEndIncluding);
    }
}
