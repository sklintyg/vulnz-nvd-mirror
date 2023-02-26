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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityAdvisories {

    @JsonProperty(value = "data", access = JsonProperty.Access.WRITE_ONLY)
    private Data data;

    /**
     * Returns the current rate limit information.
     *
     * @return the rate limit.
     */
    @JsonIgnore
    RateLimit getRateLimit() {
        if (data == null) {
            return null;
        }
        return data.rateLimit;
    }

    /**
     * Returns the list of security advisories.
     *
     * @return the security advisories.
     */
    public List<SecurityAdvisory> getSecurityAdvisories() {
        if (data == null || data.securityAdvisories == null) {
            return null;
        }
        return data.securityAdvisories.nodes;
    }

    void setSecurityAdvisories(List<SecurityAdvisory> advisories) {
        if (data == null) {
            data = new Data();
            data.securityAdvisories = new Advisories();
        }
        data.securityAdvisories.nodes = advisories;
    }

    /**
     * Returns the current page info.
     *
     * @return the page info.
     */
    @JsonIgnore
    PageInfo getPageInfo() {
        if (data == null || data.securityAdvisories == null) {
            return null;
        }
        return data.securityAdvisories.getPageInfo();
    }

    /**
     * The total count of security advisories.
     *
     * @return the total count.
     */
    @JsonIgnore
    public int getTotalCount() {
        if (data == null || data.securityAdvisories == null) {
            return 0;
        }
        return data.securityAdvisories.getTotalCount();
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
        SecurityAdvisories that = (SecurityAdvisories) o;
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
        @JsonProperty("securityAdvisories")
        private Advisories securityAdvisories;

        @Override
        public String toString() {
            return "Data{" + "rateLimit=" + rateLimit + ", securityAdvisories=" + securityAdvisories + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Data data = (Data) o;
            return Objects.equals(rateLimit, data.rateLimit)
                    && Objects.equals(securityAdvisories, data.securityAdvisories);
        }

        @Override
        public int hashCode() {
            return Objects.hash(rateLimit, securityAdvisories);
        }
    }

    /**
     * internal security advisories.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Advisories extends AbstractPageable {

        @JsonProperty("nodes")
        private List<SecurityAdvisory> nodes;

        @Override
        public String toString() {
            return "SecurityAdvisories{" + "nodes=" + nodes + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Advisories that = (Advisories) o;
            return Objects.equals(nodes, that.nodes);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nodes);
        }
    }

}
