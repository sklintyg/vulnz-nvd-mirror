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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Metric scores for a vulnerability as found on NVD.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"cvssMetricV31", "cvssMetricV30", "cvssMetricV2"})
public class Metrics {

    /**
     * CVSS V3.1 score.
     */
    @JsonProperty("cvssMetricV31")
    @JsonPropertyDescription("CVSS V3.1 score.")
    private List<CvssV31> cvssMetricV31;
    /**
     * CVSS V3.0 score.
     */
    @JsonProperty("cvssMetricV30")
    @JsonPropertyDescription("CVSS V3.0 score.")
    private List<CvssV30> cvssMetricV30;
    /**
     * CVSS V2.0 score.
     */
    @JsonProperty("cvssMetricV2")
    @JsonPropertyDescription("CVSS V2.0 score.")
    private List<CvssV2> cvssMetricV2;

    /**
     * CVSS V3.1 score.
     *
     * @return cvssMetricV31
     */
    @JsonProperty("cvssMetricV31")
    public List<CvssV31> getCvssMetricV31() {
        return cvssMetricV31;
    }

    /**
     * CVSS V3.0 score.
     *
     * @return cvssMetricV30
     */
    @JsonProperty("cvssMetricV30")
    public List<CvssV30> getCvssMetricV30() {
        return cvssMetricV30;
    }

    /**
     * CVSS V2.0 score.
     *
     * @return cvssMetricV2
     */
    @JsonProperty("cvssMetricV2")
    public List<CvssV2> getCvssMetricV2() {
        return cvssMetricV2;
    }

    @Override
    public String toString() {
        return "Metrics{" + "cvssMetricV31=" + cvssMetricV31 + ", cvssMetricV30=" + cvssMetricV30 + ", cvssMetricV2="
                + cvssMetricV2 + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Metrics metrics = (Metrics) o;
        return Objects.equals(cvssMetricV31, metrics.cvssMetricV31)
                && Objects.equals(cvssMetricV30, metrics.cvssMetricV30)
                && Objects.equals(cvssMetricV2, metrics.cvssMetricV2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cvssMetricV31, cvssMetricV30, cvssMetricV2);
    }
}
