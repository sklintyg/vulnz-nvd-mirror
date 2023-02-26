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
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.List;
import java.util.Objects;

public class CWEs extends AbstractPageable {

    @JsonProperty("edges")
    private List<CWE> cwes;

    @SuppressFBWarnings(value = {"EI_EXPOSE_REP",
            "EI_EXPOSE_REP2"}, justification = "I prefer to suppress these FindBugs warnings")
    @JsonIgnore
    public List<CWE> getEdges() {
        return cwes;
    }

    @Override
    public String toString() {
        return "CWEs{" + "cwes=" + cwes + ", totalCount=" + getTotalCount() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CWEs cwePage = (CWEs) o;
        return Objects.equals(cwes, cwePage.cwes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cwes);
    }

    boolean addCwes(List<CWE> c) {
        return this.cwes.addAll(c);
    }

}
