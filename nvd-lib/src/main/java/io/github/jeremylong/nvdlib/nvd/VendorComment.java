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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.ZonedDateTime;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"organization", "comment", "lastModified"})
public class VendorComment {

    /**
     * (Required)
     */
    @JsonProperty("organization")
    private String organization;
    /**
     * (Required)
     */
    @JsonProperty("comment")
    private String comment;
    /**
     * (Required)
     */
    @JsonProperty("lastModified")
    // the below format is a hack work around due to some poorly formated dates in the NVD data, the getter corrects the
    // serizlized format
    @JsonFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss[.[SSSSSSSSS][SSSSSSSS][SSSSSSS][SSSSSS][SSSSS][SSSS][SSS][SS][S]]", timezone = "UTC")
    private ZonedDateTime lastModified;

    /**
     * (Required)
     *
     * @return organization
     */
    @JsonProperty("organization")
    public String getOrganization() {
        return organization;
    }

    /**
     * (Required)
     *
     * @return comment
     */
    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    /**
     * (Required)
     *
     * @return lastModified
     */
    @JsonProperty("lastModified")
    @JsonFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss.SSS", timezone = "UTC")
    public ZonedDateTime getLastModified() {
        return lastModified;
    }

    @Override
    public String toString() {
        return "VendorComment{" + "organization='" + organization + '\'' + ", comment='" + comment + '\''
                + ", lastModified=" + lastModified + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        VendorComment that = (VendorComment) o;
        return Objects.equals(organization, that.organization) && Objects.equals(comment, that.comment)
                && Objects.equals(lastModified, that.lastModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organization, comment, lastModified);
    }
}
