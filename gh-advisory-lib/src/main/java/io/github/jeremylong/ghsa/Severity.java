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

/**
 * Severity of the vulnerability.
 *
 * <pre>
 * enum SecurityAdvisorySeverity
 * </pre>
 */
public enum Severity {

    CRITICAL("CRITICAL"), HIGH("HIGH"), LOW("LOW"), MODERATE("MODERATE");

    private final String value;

    Severity(String graphQlValue) {
        this.value = graphQlValue;
    }

    /**
     * Returns the enum constant of this type with the specified name.
     *
     * @param value the value.
     * @return the enum constant with the specified name.
     * @throws IllegalArgumentException if this enum type has no constant with the specified GraphQL name
     */
    static public Severity fromValue(String value) {
        if (value == null) {
            return null;
        }
        for (Severity e : Severity.values()) {
            if (e.value().equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("No Severity exists with '" + value + "' as a value");
    }

    /**
     * Returns the value of this constant.
     *
     * @return the enum constant with the specified name.
     */
    public String value() {
        return value;
    }

}
