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
 * Copyright (c) 2022-2023 Jeremy Long. All Rights Reserved.
 */
package io.github.jeremylong.ghsa;

/**
 * Exception thrown if there is a problem calling the NVD APIs.
 *
 * @author Jeremy Long
 */
public class GitHubSecurityAdvisoryException extends RuntimeException {
    /**
     * Generate a new exception.
     *
     * @param message the message
     */
    public GitHubSecurityAdvisoryException(String message) {
        super(message);
    }

    /**
     * Generate a new exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public GitHubSecurityAdvisoryException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Generate a new exception.
     *
     * @param cause the cause
     */
    public GitHubSecurityAdvisoryException(Throwable cause) {
        super(cause);
    }
}

/*
 * 
 * { securityAdvisory(nodeId: "MDU6U2VjdXJpdHlBZHZpc29yeTEyMzQ1Ng==") { id publishedAt updatedAt withdrawnAt severity
 * severityReason reference permalink description origin vulnerableSoftware { package version } unsupportedPackages {
 * name } identifiers { type value } advisories { nodes { id databaseId } } nonAffectingPackages { package }
 * firstPatchedVersion { identifier } } }
 * 
 */