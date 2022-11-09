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
package dev.jeremylong.nvd.cli;

import dev.jeremylong.nvd.cli.commands.MainCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;


@SpringBootApplication
public class Application implements CommandLineRunner, ExitCodeGenerator {
    private CommandLine.IFactory factory;
    private MainCommand command;
    private int exitCode;

    Application(CommandLine.IFactory factory, MainCommand command) {
        this.factory = factory;
        this.command = command;
    }

    public static void main(String[] args) {
        String[] arguments = args;
        if (arguments.length == 0) {
            arguments = new String[]{"--help"};
        }
        System.exit(SpringApplication.exit(SpringApplication.run(Application.class, arguments)));
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }

    @Override
    public void run(String... args) {
        exitCode = new CommandLine(command, factory).execute(args);
    }
}
