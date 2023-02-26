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
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vulnerabilities extends AbstractPageable {

    @JsonProperty("edges")
    private List<Vulnerability> vulnerabilities;

    @SuppressFBWarnings(value = {"EI_EXPOSE_REP",
            "EI_EXPOSE_REP2"}, justification = "I prefer to suppress these FindBugs warnings")
    @JsonIgnore
    public List<Vulnerability> getEdges() {
        return vulnerabilities;
    }

    boolean addVulnerabilties(List<Vulnerability> v) {
        return vulnerabilities.addAll(v);
    }

    @Override
    public String toString() {
        return "Vulnerabilities{" + "vulnerabilities=" + vulnerabilities + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Vulnerabilities that = (Vulnerabilities) o;
        return Objects.equals(vulnerabilities, that.vulnerabilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vulnerabilities);
    }

}
