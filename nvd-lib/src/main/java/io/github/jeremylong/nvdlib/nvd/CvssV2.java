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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"source", "type", "cvssData", "baseSeverity", "exploitabilityScore", "impactScore", "acInsufInfo",
        "obtainAllPrivilege", "obtainUserPrivilege", "obtainOtherPrivilege", "userInteractionRequired"})
public class CvssV2 {

    /**
     * (Required)
     */
    @JsonProperty("source")
    private String source;
    /**
     * (Required)
     */
    @JsonProperty("type")
    private Type type;
    /**
     * JSON Schema for Common Vulnerability Scoring System version 2.0
     *
     * (Required)
     */
    @JsonProperty("cvssData")
    private CvssV20 cvssData;
    @JsonProperty("baseSeverity")
    private String baseSeverity;
    /**
     * CVSS subscore.
     */
    @JsonProperty("exploitabilityScore")
    @JsonPropertyDescription("CVSS subscore.")
    private Double exploitabilityScore;
    /**
     * CVSS subscore.
     */
    @JsonProperty("impactScore")
    @JsonPropertyDescription("CVSS subscore.")
    private Double impactScore;
    @JsonProperty("acInsufInfo")
    private Boolean acInsufInfo;
    @JsonProperty("obtainAllPrivilege")
    private Boolean obtainAllPrivilege;
    @JsonProperty("obtainUserPrivilege")
    private Boolean obtainUserPrivilege;
    @JsonProperty("obtainOtherPrivilege")
    private Boolean obtainOtherPrivilege;
    @JsonProperty("userInteractionRequired")
    private Boolean userInteractionRequired;

    /**
     * (Required)
     *
     * @return source
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * (Required)
     *
     * @return type
     */
    @JsonProperty("type")
    public Type getType() {
        return type;
    }

    /**
     * JSON Schema for Common Vulnerability Scoring System version 2.0
     *
     * (Required)
     *
     * @return cvssData
     */
    @JsonProperty("cvssData")
    public CvssV20 getCvssData() {
        return cvssData;
    }

    /**
     * @return baseSeverity
     */
    @JsonProperty("baseSeverity")
    public String getBaseSeverity() {
        return baseSeverity;
    }

    /**
     * CVSS subscore.
     *
     * @return exploitabilityScore
     */
    @JsonProperty("exploitabilityScore")
    public Double getExploitabilityScore() {
        return exploitabilityScore;
    }

    /**
     * CVSS subscore.
     *
     * @return impactScore
     */
    @JsonProperty("impactScore")
    public Double getImpactScore() {
        return impactScore;
    }

    /**
     * @return acInsufInfo
     */
    @JsonProperty("acInsufInfo")
    public Boolean getAcInsufInfo() {
        return acInsufInfo;
    }

    /**
     * @return obtainAllPrivilege
     */
    @JsonProperty("obtainAllPrivilege")
    public Boolean getObtainAllPrivilege() {
        return obtainAllPrivilege;
    }

    /**
     * @return obtainUserPrivilege
     */
    @JsonProperty("obtainUserPrivilege")
    public Boolean getObtainUserPrivilege() {
        return obtainUserPrivilege;
    }

    /**
     * @return obtainOtherPrivilege
     */
    @JsonProperty("obtainOtherPrivilege")
    public Boolean getObtainOtherPrivilege() {
        return obtainOtherPrivilege;
    }

    /**
     * @return userInteractionRequired
     */
    @JsonProperty("userInteractionRequired")
    public Boolean getUserInteractionRequired() {
        return userInteractionRequired;
    }

    @Override
    public String toString() {
        return "CvssV2{" + "source='" + source + '\'' + ", type=" + type + ", cvssData=" + cvssData + ", baseSeverity='"
                + baseSeverity + '\'' + ", exploitabilityScore=" + exploitabilityScore + ", impactScore=" + impactScore
                + ", acInsufInfo=" + acInsufInfo + ", obtainAllPrivilege=" + obtainAllPrivilege
                + ", obtainUserPrivilege=" + obtainUserPrivilege + ", obtainOtherPrivilege=" + obtainOtherPrivilege
                + ", userInteractionRequired=" + userInteractionRequired + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CvssV2 cvssV2 = (CvssV2) o;
        return Objects.equals(source, cvssV2.source) && type == cvssV2.type && Objects.equals(cvssData, cvssV2.cvssData)
                && Objects.equals(baseSeverity, cvssV2.baseSeverity)
                && Objects.equals(exploitabilityScore, cvssV2.exploitabilityScore)
                && Objects.equals(impactScore, cvssV2.impactScore) && Objects.equals(acInsufInfo, cvssV2.acInsufInfo)
                && Objects.equals(obtainAllPrivilege, cvssV2.obtainAllPrivilege)
                && Objects.equals(obtainUserPrivilege, cvssV2.obtainUserPrivilege)
                && Objects.equals(obtainOtherPrivilege, cvssV2.obtainOtherPrivilege)
                && Objects.equals(userInteractionRequired, cvssV2.userInteractionRequired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, type, cvssData, baseSeverity, exploitabilityScore, impactScore, acInsufInfo,
                obtainAllPrivilege, obtainUserPrivilege, obtainOtherPrivilege, userInteractionRequired);
    }

    public enum Type {

        PRIMARY("Primary"), SECONDARY("Secondary");

        private final static Map<String, Type> CONSTANTS = new HashMap<>();

        static {
            for (Type c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        Type(String value) {
            this.value = value;
        }

        @JsonCreator
        public static Type fromValue(String value) {
            Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

    }

}
