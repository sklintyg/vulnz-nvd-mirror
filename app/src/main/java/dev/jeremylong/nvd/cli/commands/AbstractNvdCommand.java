/*
 *  Copyright 2022 Jeremy Long
 *
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
 */
package dev.jeremylong.nvd.cli.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;

public abstract class AbstractNvdCommand extends AbstractHelpfulCommand {
    /**
     * Reference to the logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(AbstractNvdCommand.class);
    //yes - this should not be a string, but seriously down the call path the HttpClient
    // doesn't support passing a header in as a char[]...
    private String apiKey = null;

    @CommandLine.Option(names = {"--delay"}, description = "The delay in milliseconds between API calls to the NVD - important if pulling a larger data set without an API Key", defaultValue = "2000")
    private int delay = 2000;

    protected int getDelay() {
        return delay;
    }

    /**
     * Returns the NVD API Key if supplied.
     *
     * @return the NVD API Key if supplied; otherwise <code>null</code>
     */
    protected String getApiKey() {
        if (apiKey == null && System.getenv("NVD_API_KEY") != null) {
            return System.getenv("NVD_API_KEY");
        }
        return apiKey;
    }

    @CommandLine.Option(names = {"--apikey"}, description = "NVD API Key", interactive = true)
    public void setApiKey(String apiKey) {
        LOG.warn("For easier use - consider setting an environment variable NVD_API_KEY.\n\nSee TODO for more information");
        this.apiKey = apiKey;
    }
}
