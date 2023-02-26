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
package io.github.jeremylong.nvdlib.nvd;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * JSON Schema for Common Vulnerability Scoring System version 3.1
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"version", "vectorString", "attackVector", "attackComplexity", "privilegesRequired",
        "userInteraction", "scope", "confidentialityImpact", "integrityImpact", "availabilityImpact", "baseScore",
        "baseSeverity", "exploitCodeMaturity", "remediationLevel", "reportConfidence", "temporalScore",
        "temporalSeverity", "confidentialityRequirement", "integrityRequirement", "availabilityRequirement",
        "modifiedAttackVector", "modifiedAttackComplexity", "modifiedPrivilegesRequired", "modifiedUserInteraction",
        "modifiedScope", "modifiedConfidentialityImpact", "modifiedIntegrityImpact", "modifiedAvailabilityImpact",
        "environmentalScore", "environmentalSeverity"})
public class CvssV31Data {

    /**
     * CVSS Version (Required)
     */
    @JsonProperty("version")
    @JsonPropertyDescription("CVSS Version")
    private Version version;
    /**
     * (Required)
     */
    @JsonProperty("vectorString")
    private String vectorString;
    @JsonProperty("attackVector")
    private AttackVectorType attackVector;
    @JsonProperty("attackComplexity")
    private AttackComplexityType attackComplexity;
    @JsonProperty("privilegesRequired")
    private PrivilegesRequiredType privilegesRequired;
    @JsonProperty("userInteraction")
    private UserInteractionType userInteraction;
    @JsonProperty("scope")
    private ScopeType scope;
    @JsonProperty("confidentialityImpact")
    private CiaType confidentialityImpact;
    @JsonProperty("integrityImpact")
    private CiaType integrityImpact;
    @JsonProperty("availabilityImpact")
    private CiaType availabilityImpact;
    /**
     * (Required)
     */
    @JsonProperty("baseScore")
    private Double baseScore;
    /**
     * (Required)
     */
    @JsonProperty("baseSeverity")
    private SeverityType baseSeverity;
    @JsonProperty("exploitCodeMaturity")
    private ExploitCodeMaturityType exploitCodeMaturity;
    @JsonProperty("remediationLevel")
    private RemediationLevelType remediationLevel;
    @JsonProperty("reportConfidence")
    private ConfidenceType reportConfidence;
    @JsonProperty("temporalScore")
    private Double temporalScore;
    @JsonProperty("temporalSeverity")
    private SeverityType temporalSeverity;
    @JsonProperty("confidentialityRequirement")
    private CiaRequirementType confidentialityRequirement;
    @JsonProperty("integrityRequirement")
    private CiaRequirementType integrityRequirement;
    @JsonProperty("availabilityRequirement")
    private CiaRequirementType availabilityRequirement;
    @JsonProperty("modifiedAttackVector")
    private ModifiedAttackVectorType modifiedAttackVector;
    @JsonProperty("modifiedAttackComplexity")
    private ModifiedAttackComplexityType modifiedAttackComplexity;
    @JsonProperty("modifiedPrivilegesRequired")
    private ModifiedPrivilegesRequiredType modifiedPrivilegesRequired;
    @JsonProperty("modifiedUserInteraction")
    private ModifiedUserInteractionType modifiedUserInteraction;
    @JsonProperty("modifiedScope")
    private ModifiedScopeType modifiedScope;
    @JsonProperty("modifiedConfidentialityImpact")
    private ModifiedCiaType modifiedConfidentialityImpact;
    @JsonProperty("modifiedIntegrityImpact")
    private ModifiedCiaType modifiedIntegrityImpact;
    @JsonProperty("modifiedAvailabilityImpact")
    private ModifiedCiaType modifiedAvailabilityImpact;
    @JsonProperty("environmentalScore")
    private Double environmentalScore;
    @JsonProperty("environmentalSeverity")
    private SeverityType environmentalSeverity;

    /**
     * CVSS Version (Required)
     *
     * @return version
     */
    @JsonProperty("version")
    public Version getVersion() {
        return version;
    }

    /**
     * (Required)
     *
     * @return vectorString
     */
    @JsonProperty("vectorString")
    public String getVectorString() {
        return vectorString;
    }

    /**
     * @return attackVector
     */
    @JsonProperty("attackVector")
    public AttackVectorType getAttackVector() {
        return attackVector;
    }

    /**
     * @return attackComplexity
     */
    @JsonProperty("attackComplexity")
    public AttackComplexityType getAttackComplexity() {
        return attackComplexity;
    }

    /**
     * @return privilegesRequired
     */
    @JsonProperty("privilegesRequired")
    public PrivilegesRequiredType getPrivilegesRequired() {
        return privilegesRequired;
    }

    /**
     * @return userInteraction
     */
    @JsonProperty("userInteraction")
    public UserInteractionType getUserInteraction() {
        return userInteraction;
    }

    /**
     * @return scope
     */
    @JsonProperty("scope")
    public ScopeType getScope() {
        return scope;
    }

    /**
     * @return confidentialityImpact
     */
    @JsonProperty("confidentialityImpact")
    public CiaType getConfidentialityImpact() {
        return confidentialityImpact;
    }

    /**
     * @return integrityImpact
     */
    @JsonProperty("integrityImpact")
    public CiaType getIntegrityImpact() {
        return integrityImpact;
    }

    /**
     * @return availabilityImpact
     */
    @JsonProperty("availabilityImpact")
    public CiaType getAvailabilityImpact() {
        return availabilityImpact;
    }

    /**
     * (Required)
     *
     * @return baseScore
     */
    @JsonProperty("baseScore")
    public Double getBaseScore() {
        return baseScore;
    }

    /**
     * (Required)
     *
     * @return baseSeverity
     */
    @JsonProperty("baseSeverity")
    public SeverityType getBaseSeverity() {
        return baseSeverity;
    }

    /**
     * @return exploitCodeMaturity
     */
    @JsonProperty("exploitCodeMaturity")
    public ExploitCodeMaturityType getExploitCodeMaturity() {
        return exploitCodeMaturity;
    }

    /**
     * @return remediationLevel
     */
    @JsonProperty("remediationLevel")
    public RemediationLevelType getRemediationLevel() {
        return remediationLevel;
    }

    /**
     * @return reportConfidence
     */
    @JsonProperty("reportConfidence")
    public ConfidenceType getReportConfidence() {
        return reportConfidence;
    }

    /**
     * @return temporalScore
     */
    @JsonProperty("temporalScore")
    public Double getTemporalScore() {
        return temporalScore;
    }

    /**
     * @return temporalSeverity
     */
    @JsonProperty("temporalSeverity")
    public SeverityType getTemporalSeverity() {
        return temporalSeverity;
    }

    /**
     * @return confidentialityRequirement
     */
    @JsonProperty("confidentialityRequirement")
    public CiaRequirementType getConfidentialityRequirement() {
        return confidentialityRequirement;
    }

    /**
     * @return integrityRequirement
     */
    @JsonProperty("integrityRequirement")
    public CiaRequirementType getIntegrityRequirement() {
        return integrityRequirement;
    }

    /**
     * @return availabilityRequirement
     */
    @JsonProperty("availabilityRequirement")
    public CiaRequirementType getAvailabilityRequirement() {
        return availabilityRequirement;
    }

    /**
     * @return modifiedAttackVector
     */
    @JsonProperty("modifiedAttackVector")
    public ModifiedAttackVectorType getModifiedAttackVector() {
        return modifiedAttackVector;
    }

    /**
     * @return modifiedAttackComplexity
     */
    @JsonProperty("modifiedAttackComplexity")
    public ModifiedAttackComplexityType getModifiedAttackComplexity() {
        return modifiedAttackComplexity;
    }

    /**
     * @return modifiedPrivilegesRequired
     */
    @JsonProperty("modifiedPrivilegesRequired")
    public ModifiedPrivilegesRequiredType getModifiedPrivilegesRequired() {
        return modifiedPrivilegesRequired;
    }

    /**
     * @return modifiedUserInteraction
     */
    @JsonProperty("modifiedUserInteraction")
    public ModifiedUserInteractionType getModifiedUserInteraction() {
        return modifiedUserInteraction;
    }

    /**
     * @return modifiedScope
     */
    @JsonProperty("modifiedScope")
    public ModifiedScopeType getModifiedScope() {
        return modifiedScope;
    }

    /**
     * @return modifiedConfidentialityImpact
     */
    @JsonProperty("modifiedConfidentialityImpact")
    public ModifiedCiaType getModifiedConfidentialityImpact() {
        return modifiedConfidentialityImpact;
    }

    /**
     * @return modifiedIntegrityImpact
     */
    @JsonProperty("modifiedIntegrityImpact")
    public ModifiedCiaType getModifiedIntegrityImpact() {
        return modifiedIntegrityImpact;
    }

    /**
     * @return modifiedAvailabilityImpact
     */
    @JsonProperty("modifiedAvailabilityImpact")
    public ModifiedCiaType getModifiedAvailabilityImpact() {
        return modifiedAvailabilityImpact;
    }

    /**
     * @return environmentalScore
     */
    @JsonProperty("environmentalScore")
    public Double getEnvironmentalScore() {
        return environmentalScore;
    }

    /**
     * @return environmentalSeverity
     */
    @JsonProperty("environmentalSeverity")
    public SeverityType getEnvironmentalSeverity() {
        return environmentalSeverity;
    }

    @Override
    public String toString() {
        return "CvssV31Data{" + "version=" + version + ", vectorString='" + vectorString + '\'' + ", attackVector="
                + attackVector + ", attackComplexity=" + attackComplexity + ", privilegesRequired=" + privilegesRequired
                + ", userInteraction=" + userInteraction + ", scope=" + scope + ", confidentialityImpact="
                + confidentialityImpact + ", integrityImpact=" + integrityImpact + ", availabilityImpact="
                + availabilityImpact + ", baseScore=" + baseScore + ", baseSeverity=" + baseSeverity
                + ", exploitCodeMaturity=" + exploitCodeMaturity + ", remediationLevel=" + remediationLevel
                + ", reportConfidence=" + reportConfidence + ", temporalScore=" + temporalScore + ", temporalSeverity="
                + temporalSeverity + ", confidentialityRequirement=" + confidentialityRequirement
                + ", integrityRequirement=" + integrityRequirement + ", availabilityRequirement="
                + availabilityRequirement + ", modifiedAttackVector=" + modifiedAttackVector
                + ", modifiedAttackComplexity=" + modifiedAttackComplexity + ", modifiedPrivilegesRequired="
                + modifiedPrivilegesRequired + ", modifiedUserInteraction=" + modifiedUserInteraction
                + ", modifiedScope=" + modifiedScope + ", modifiedConfidentialityImpact="
                + modifiedConfidentialityImpact + ", modifiedIntegrityImpact=" + modifiedIntegrityImpact
                + ", modifiedAvailabilityImpact=" + modifiedAvailabilityImpact + ", environmentalScore="
                + environmentalScore + ", environmentalSeverity=" + environmentalSeverity + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CvssV31Data that = (CvssV31Data) o;
        return version == that.version && Objects.equals(vectorString, that.vectorString)
                && attackVector == that.attackVector && attackComplexity == that.attackComplexity
                && privilegesRequired == that.privilegesRequired && userInteraction == that.userInteraction
                && scope == that.scope && confidentialityImpact == that.confidentialityImpact
                && integrityImpact == that.integrityImpact && availabilityImpact == that.availabilityImpact
                && Objects.equals(baseScore, that.baseScore) && baseSeverity == that.baseSeverity
                && exploitCodeMaturity == that.exploitCodeMaturity && remediationLevel == that.remediationLevel
                && reportConfidence == that.reportConfidence && Objects.equals(temporalScore, that.temporalScore)
                && temporalSeverity == that.temporalSeverity
                && confidentialityRequirement == that.confidentialityRequirement
                && integrityRequirement == that.integrityRequirement
                && availabilityRequirement == that.availabilityRequirement
                && modifiedAttackVector == that.modifiedAttackVector
                && modifiedAttackComplexity == that.modifiedAttackComplexity
                && modifiedPrivilegesRequired == that.modifiedPrivilegesRequired
                && modifiedUserInteraction == that.modifiedUserInteraction && modifiedScope == that.modifiedScope
                && modifiedConfidentialityImpact == that.modifiedConfidentialityImpact
                && modifiedIntegrityImpact == that.modifiedIntegrityImpact
                && modifiedAvailabilityImpact == that.modifiedAvailabilityImpact
                && Objects.equals(environmentalScore, that.environmentalScore)
                && environmentalSeverity == that.environmentalSeverity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, vectorString, attackVector, attackComplexity, privilegesRequired, userInteraction,
                scope, confidentialityImpact, integrityImpact, availabilityImpact, baseScore, baseSeverity,
                exploitCodeMaturity, remediationLevel, reportConfidence, temporalScore, temporalSeverity,
                confidentialityRequirement, integrityRequirement, availabilityRequirement, modifiedAttackVector,
                modifiedAttackComplexity, modifiedPrivilegesRequired, modifiedUserInteraction, modifiedScope,
                modifiedConfidentialityImpact, modifiedIntegrityImpact, modifiedAvailabilityImpact, environmentalScore,
                environmentalSeverity);
    }

    public enum AttackComplexityType {

        HIGH("HIGH"), LOW("LOW");

        private final static Map<String, AttackComplexityType> CONSTANTS = new HashMap<>();

        static {
            for (AttackComplexityType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        AttackComplexityType(String value) {
            this.value = value;
        }

        @JsonCreator
        public static AttackComplexityType fromValue(String value) {
            AttackComplexityType constant = CONSTANTS.get(value);
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

    public enum AttackVectorType {

        NETWORK("NETWORK"), ADJACENT_NETWORK("ADJACENT_NETWORK"), LOCAL("LOCAL"), PHYSICAL("PHYSICAL");

        private final static Map<String, AttackVectorType> CONSTANTS = new HashMap<>();

        static {
            for (AttackVectorType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        AttackVectorType(String value) {
            this.value = value;
        }

        @JsonCreator
        public static AttackVectorType fromValue(String value) {
            AttackVectorType constant = CONSTANTS.get(value);
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

    public enum CiaRequirementType {

        LOW("LOW"), MEDIUM("MEDIUM"), HIGH("HIGH"), NOT_DEFINED("NOT_DEFINED");

        private final static Map<String, CiaRequirementType> CONSTANTS = new HashMap<>();

        static {
            for (CiaRequirementType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        CiaRequirementType(String value) {
            this.value = value;
        }

        @JsonCreator
        public static CiaRequirementType fromValue(String value) {
            CiaRequirementType constant = CONSTANTS.get(value);
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

    public enum CiaType {

        NONE("NONE"), LOW("LOW"), HIGH("HIGH");

        private final static Map<String, CiaType> CONSTANTS = new HashMap<>();

        static {
            for (CiaType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        CiaType(String value) {
            this.value = value;
        }

        @JsonCreator
        public static CiaType fromValue(String value) {
            CiaType constant = CONSTANTS.get(value);
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

    public enum ConfidenceType {

        UNKNOWN("UNKNOWN"), REASONABLE("REASONABLE"), CONFIRMED("CONFIRMED"), NOT_DEFINED("NOT_DEFINED");

        private final static Map<String, ConfidenceType> CONSTANTS = new HashMap<>();

        static {
            for (ConfidenceType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        ConfidenceType(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ConfidenceType fromValue(String value) {
            ConfidenceType constant = CONSTANTS.get(value);
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

    public enum ExploitCodeMaturityType {

        UNPROVEN("UNPROVEN"), PROOF_OF_CONCEPT("PROOF_OF_CONCEPT"), FUNCTIONAL("FUNCTIONAL"), HIGH("HIGH"), NOT_DEFINED(
                "NOT_DEFINED");

        private final static Map<String, ExploitCodeMaturityType> CONSTANTS = new HashMap<>();

        static {
            for (ExploitCodeMaturityType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        ExploitCodeMaturityType(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ExploitCodeMaturityType fromValue(String value) {
            ExploitCodeMaturityType constant = CONSTANTS.get(value);
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

    public enum ModifiedAttackComplexityType {

        HIGH("HIGH"), LOW("LOW"), NOT_DEFINED("NOT_DEFINED");

        private final static Map<String, ModifiedAttackComplexityType> CONSTANTS = new HashMap<>();

        static {
            for (ModifiedAttackComplexityType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        ModifiedAttackComplexityType(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ModifiedAttackComplexityType fromValue(String value) {
            ModifiedAttackComplexityType constant = CONSTANTS.get(value);
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

    public enum ModifiedAttackVectorType {

        NETWORK("NETWORK"), ADJACENT_NETWORK("ADJACENT_NETWORK"), LOCAL("LOCAL"), PHYSICAL("PHYSICAL"), NOT_DEFINED(
                "NOT_DEFINED");

        private final static Map<String, ModifiedAttackVectorType> CONSTANTS = new HashMap<>();

        static {
            for (ModifiedAttackVectorType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        ModifiedAttackVectorType(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ModifiedAttackVectorType fromValue(String value) {
            ModifiedAttackVectorType constant = CONSTANTS.get(value);
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

    public enum ModifiedCiaType {

        NONE("NONE"), LOW("LOW"), HIGH("HIGH"), NOT_DEFINED("NOT_DEFINED");

        private final static Map<String, ModifiedCiaType> CONSTANTS = new HashMap<>();

        static {
            for (ModifiedCiaType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        ModifiedCiaType(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ModifiedCiaType fromValue(String value) {
            ModifiedCiaType constant = CONSTANTS.get(value);
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

    public enum ModifiedPrivilegesRequiredType {

        HIGH("HIGH"), LOW("LOW"), NONE("NONE"), NOT_DEFINED("NOT_DEFINED");

        private final static Map<String, ModifiedPrivilegesRequiredType> CONSTANTS = new HashMap<>();

        static {
            for (ModifiedPrivilegesRequiredType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        ModifiedPrivilegesRequiredType(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ModifiedPrivilegesRequiredType fromValue(String value) {
            ModifiedPrivilegesRequiredType constant = CONSTANTS.get(value);
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

    public enum ModifiedScopeType {

        UNCHANGED("UNCHANGED"), CHANGED("CHANGED"), NOT_DEFINED("NOT_DEFINED");

        private final static Map<String, ModifiedScopeType> CONSTANTS = new HashMap<>();

        static {
            for (ModifiedScopeType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        ModifiedScopeType(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ModifiedScopeType fromValue(String value) {
            ModifiedScopeType constant = CONSTANTS.get(value);
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

    public enum ModifiedUserInteractionType {

        NONE("NONE"), REQUIRED("REQUIRED"), NOT_DEFINED("NOT_DEFINED");

        private final static Map<String, ModifiedUserInteractionType> CONSTANTS = new HashMap<>();

        static {
            for (ModifiedUserInteractionType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        ModifiedUserInteractionType(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ModifiedUserInteractionType fromValue(String value) {
            ModifiedUserInteractionType constant = CONSTANTS.get(value);
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

    public enum PrivilegesRequiredType {

        HIGH("HIGH"), LOW("LOW"), NONE("NONE");

        private final static Map<String, PrivilegesRequiredType> CONSTANTS = new HashMap<>();

        static {
            for (PrivilegesRequiredType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        PrivilegesRequiredType(String value) {
            this.value = value;
        }

        @JsonCreator
        public static PrivilegesRequiredType fromValue(String value) {
            PrivilegesRequiredType constant = CONSTANTS.get(value);
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

    public enum RemediationLevelType {

        OFFICIAL_FIX("OFFICIAL_FIX"), TEMPORARY_FIX("TEMPORARY_FIX"), WORKAROUND("WORKAROUND"), UNAVAILABLE(
                "UNAVAILABLE"), NOT_DEFINED("NOT_DEFINED");

        private final static Map<String, RemediationLevelType> CONSTANTS = new HashMap<>();

        static {
            for (RemediationLevelType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        RemediationLevelType(String value) {
            this.value = value;
        }

        @JsonCreator
        public static RemediationLevelType fromValue(String value) {
            RemediationLevelType constant = CONSTANTS.get(value);
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

    public enum ScopeType {

        UNCHANGED("UNCHANGED"), CHANGED("CHANGED");

        private final static Map<String, ScopeType> CONSTANTS = new HashMap<>();

        static {
            for (ScopeType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        ScopeType(String value) {
            this.value = value;
        }

        @JsonCreator
        public static ScopeType fromValue(String value) {
            ScopeType constant = CONSTANTS.get(value);
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

    public enum SeverityType {

        NONE("NONE"), LOW("LOW"), MEDIUM("MEDIUM"), HIGH("HIGH"), CRITICAL("CRITICAL");

        private final static Map<String, SeverityType> CONSTANTS = new HashMap<>();

        static {
            for (SeverityType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        SeverityType(String value) {
            this.value = value;
        }

        @JsonCreator
        public static SeverityType fromValue(String value) {
            SeverityType constant = CONSTANTS.get(value);
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

    public enum UserInteractionType {

        NONE("NONE"), REQUIRED("REQUIRED");

        private final static Map<String, UserInteractionType> CONSTANTS = new HashMap<>();

        static {
            for (UserInteractionType c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        UserInteractionType(String value) {
            this.value = value;
        }

        @JsonCreator
        public static UserInteractionType fromValue(String value) {
            UserInteractionType constant = CONSTANTS.get(value);
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

    /**
     * CVSS Version
     */
    public enum Version {

        _3_1("3.1");

        private final static Map<String, Version> CONSTANTS = new HashMap<>();

        static {
            for (Version c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        Version(String value) {
            this.value = value;
        }

        @JsonCreator
        public static Version fromValue(String value) {
            Version constant = CONSTANTS.get(value);
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
