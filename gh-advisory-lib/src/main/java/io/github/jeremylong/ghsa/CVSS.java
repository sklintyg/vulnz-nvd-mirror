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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The Common Vulnerability Scoring System.
 *
 * <pre>
 * type CVSS
 * </pre>
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CVSS {

    @JsonProperty("score")
    java.lang.Double score;

    @JsonProperty("vectorString")
    java.lang.String vectorString;

    /**
     * The CVSS score associated with this advisory.
     *
     * @return the CVSS score.
     */
    public java.lang.Double getScore() {
        return score;
    }

    /**
     * The CVSS vector string associated with this advisory.
     *
     * @return the CVSS vector.
     */
    public java.lang.String getVectorString() {
        return vectorString;
    }

    @Override
    public String toString() {
        return "CVSS{" + "score=" + score + ", vectorString='" + vectorString + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CVSS cvss = (CVSS) o;
        return Objects.equals(score, cvss.score) && Objects.equals(vectorString, cvss.vectorString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, vectorString);
    }
}
