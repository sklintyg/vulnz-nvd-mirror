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
package io.github.jeremylong.ghsa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

/**
 * Common weakness enumeration.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"cweId", "name", "description"})
public class CWE {

    @JsonProperty(value = "node", access = JsonProperty.Access.WRITE_ONLY)
    private CWERecord node;

    /**
     * Returns the id of the CWE.
     *
     * @return the id of the CWE
     */
    public String getCweId() {
        if (node == null) {
            return null;
        }
        return node.cweId;
    }

    void setCweId(String cweId) {
        if (node == null) {
            this.node = new CWERecord();
        }
        node.cweId = cweId;
    }

    /**
     * Returns a detailed description of this CWE.
     *
     * @return a detailed description of this CWE.
     */
    public String getDescription() {
        if (node == null) {
            return null;
        }
        return node.description;
    }

    void setDescription(String description) {
        if (node == null) {
            node = new CWERecord();
        }
        node.description = description;
    }

    /**
     * The name of this CWE.
     *
     * @return the name of this CWE.
     */
    public String getName() {
        if (node == null) {
            return null;
        }
        return node.name;
    }

    void setName(String name) {
        if (node == null) {
            node = new CWERecord();
        }
        node.name = name;
    }

    @Override
    public String toString() {
        if (node == null) {
            return "";
        }
        return node.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CWE cwe = (CWE) o;
        return Objects.equals(node, cwe.node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node);
    }

    /**
     * A common weakness enumeration.
     *
     * <pre>
     * type CWE
     * </pre>
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class CWERecord {

        @JsonProperty("cweId")
        private String cweId;

        @JsonProperty("description")
        private String description;

        @JsonProperty("name")
        private String name;

        @Override
        public String toString() {
            return "CWE{" + "cweId='" + cweId + '\'' + ", description='" + description + '\'' + ", name='" + name + '\''
                    + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            CWERecord cweRecord = (CWERecord) o;
            return Objects.equals(cweId, cweRecord.cweId) && Objects.equals(description, cweRecord.description)
                    && Objects.equals(name, cweRecord.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cweId, description, name);
        }
    }
}