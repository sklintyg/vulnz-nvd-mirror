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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"operator", "negate", "nodes"})
public class Config {

    @JsonProperty("operator")
    private Operator operator;
    @JsonProperty("negate")
    private Boolean negate;
    /**
     * (Required)
     */
    @JsonProperty("nodes")
    private List<Node> nodes;

    /**
     * @return operator
     */
    @JsonProperty("operator")
    public Operator getOperator() {
        return operator;
    }

    /**
     * @return negate
     */
    @JsonProperty("negate")
    public Boolean getNegate() {
        return negate;
    }

    /**
     * (Required)
     *
     * @return nodes
     */
    @JsonProperty("nodes")
    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        return "Config{" + "operator=" + operator + ", negate=" + negate + ", nodes=" + nodes + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Config config = (Config) o;
        return operator == config.operator && Objects.equals(negate, config.negate)
                && Objects.equals(nodes, config.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator, negate, nodes);
    }

    public enum Operator {

        AND("AND"), OR("OR");

        private final static Map<String, Operator> CONSTANTS = new HashMap<>();

        static {
            for (Operator c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private final String value;

        Operator(String value) {
            this.value = value;
        }

        @JsonCreator
        public static Operator fromValue(String value) {
            Operator constant = CONSTANTS.get(value);
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
