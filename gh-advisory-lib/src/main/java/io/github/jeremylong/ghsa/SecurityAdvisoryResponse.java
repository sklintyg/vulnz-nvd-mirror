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
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * Internal class used to gather additional vulnerabilities if a security advisory has more than 100 entries.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class SecurityAdvisoryResponse {

    @JsonProperty("data")
    private Data data;

    /**
     * Returns the current rate limit information.
     *
     * @return the rate limit.
     */
    public RateLimit getRateLimit() {
        return data.rateLimit;
    }

    /**
     * Returns the security advisory.
     *
     * @return the security advisory.
     */
    public SecurityAdvisory getSecurityAdvisory() {
        return data.securityAdvisory;
    }

    @Override
    public String toString() {
        if (data == null) {
            return "";
        }
        return data.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SecurityAdvisoryResponse that = (SecurityAdvisoryResponse) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    /**
     * Internal data object.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Data {
        @JsonProperty("rateLimit")
        private RateLimit rateLimit;
        @JsonProperty("securityAdvisory")
        private SecurityAdvisory securityAdvisory;

        @Override
        public String toString() {
            return "Data{" + "rateLimit=" + rateLimit + ", securityAdvisory=" + securityAdvisory + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Data data = (Data) o;
            return Objects.equals(rateLimit, data.rateLimit) && Objects.equals(securityAdvisory, data.securityAdvisory);
        }

        @Override
        public int hashCode() {
            return Objects.hash(rateLimit, securityAdvisory);
        }
    }

    /**
     * internal security advisories.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class SecurityAdvisories {

        @JsonProperty("nodes")
        private List<SecurityAdvisory> nodes;

        @JsonProperty("totalCount")
        private int totalCount;

        @JsonProperty("pageInfo")
        private PageInfo pageInfo;

        @Override
        public String toString() {
            return "Advisories{" + "nodes=" + nodes + ", totalCount=" + totalCount + ", pageInfo=" + pageInfo + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            SecurityAdvisories that = (SecurityAdvisories) o;
            return totalCount == that.totalCount && Objects.equals(nodes, that.nodes)
                    && Objects.equals(pageInfo, that.pageInfo);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nodes, totalCount, pageInfo);
        }
    }

}
