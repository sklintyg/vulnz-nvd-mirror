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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Represents the client's rate limit.
 * 
 * <pre>
 * type RateLimit
 * </pre>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateLimit {

    @JsonProperty("limit")
    private int limit;

    @JsonProperty("cost")
    private int cost;

    @JsonProperty("remaining")
    private int remaining;

    @JsonProperty("resetAt")
    @JsonFormat(pattern = "uuu-MM-dd'T'HH:mm:ssX", timezone = "UTC")
    private ZonedDateTime resetAt;// : 2023-02-11T14:04:20Z

    /**
     * The maximum number of points the client is permitted to consume in a 60 minute window.
     *
     * @return the limit.
     */
    public int getLimit() {
        return limit;
    }

    /**
     * The point cost for the current query counting against the rate limit.
     *
     * @return the cost.
     */
    public int getCost() {
        return cost;
    }

    /**
     * The number of points remaining in the current rate limit window.
     *
     * @return the remaining points.
     */
    public int getRemaining() {
        return remaining;
    }

    /**
     * The time at which the current rate limit window resets in UTC epoch seconds.
     *
     * @return the time the rate limit window will reset.
     */
    public ZonedDateTime getResetAt() {
        return resetAt;
    }

    @Override
    public String toString() {
        return "RateLimit{" + "limit=" + limit + ", cost=" + cost + ", remaining=" + remaining + ", resetAt=" + resetAt
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RateLimit rateLimit = (RateLimit) o;
        return limit == rateLimit.limit && cost == rateLimit.cost && remaining == rateLimit.remaining
                && Objects.equals(resetAt, rateLimit.resetAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(limit, cost, remaining, resetAt);
    }
}
