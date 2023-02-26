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

import java.util.Objects;

/**
 * Information about pagination in a connection.
 * 
 * <pre>
 * type PageInfo
 * </pre>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageInfo {

    @JsonProperty("edgeshasNextPage")
    private boolean hasNextPage;

    @JsonProperty("hasPreviousPage")
    private boolean hasPreviousPage;

    @JsonProperty("endCursor")
    private String endCursor;

    @JsonProperty("startCursor")
    private String startCursor;

    /**
     * When paginating forwards, are there more items?
     *
     * @return <code>true</code> if more pages exist; otherwise <code>false</code>.
     */
    public boolean isHasNextPage() {
        return hasNextPage;
    }

    /**
     * When paginating backwards, are there more items?
     *
     * @return <code>true</code> if previous pages exist; otherwise <code>false</code>.
     */
    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    /**
     * When paginating forwards, the cursor to continue.
     *
     * @return the cursor.
     */
    public String getEndCursor() {
        return endCursor;
    }

    /**
     * When paginating backwards, the cursor to continue.
     *
     * @return the cursor.
     */
    public String getStartCursor() {
        return startCursor;
    }

    @Override
    public String toString() {
        return "PageInfo{" + "hasNextPage=" + hasNextPage + ", hasPreviousPage=" + hasPreviousPage + ", endCursor='"
                + endCursor + '\'' + ", startCursor='" + startCursor + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PageInfo pageInfo = (PageInfo) o;
        return hasNextPage == pageInfo.hasNextPage && hasPreviousPage == pageInfo.hasPreviousPage
                && Objects.equals(endCursor, pageInfo.endCursor) && Objects.equals(startCursor, pageInfo.startCursor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasNextPage, hasPreviousPage, endCursor, startCursor);
    }
}
