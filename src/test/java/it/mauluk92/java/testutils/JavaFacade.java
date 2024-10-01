package it.mauluk92.java.testutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class JavaFacade {

    private final static Logger logger = Logger.getLogger(JavaFacade.class.getName());


    public static int compile(String outputDir, String classPath, String sourcePath, String... files) {
        try {
            ProcessBuilder compileBuilder = new ProcessBuilder();
            compileBuilder.directory(new File(sourcePath));
            List<String> commands = new ArrayList<>();
            commands.add("javac");
            commands.add("-cp");
            commands.add(classPath);
            commands.add("-d");
            commands.add(outputDir);
            commands.addAll(Arrays.stream(files).collect(Collectors.toList()));
            compileBuilder.command(commands);
            Process compileProcess = compileBuilder.start();
            BufferedReader compileErrorReader = new BufferedReader(new InputStreamReader(compileProcess.getErrorStream()));
            StringBuilder compileErrors = new StringBuilder();
            String line;
            while ((line = compileErrorReader.readLine()) != null) {
                compileErrors.append(line).append("\n");
            }
            int compileExitCode = compileProcess.waitFor();
            if (compileExitCode != 0) {
                logger.info("Error during compilation (exit code " + compileExitCode + "):");
                logger.info(compileErrors.toString());
            } else {
                logger.info("Compiled successfully.");
            }
            return compileExitCode;
        } catch (IOException | InterruptedException e) {
            logger.severe(e.getMessage());
            return -1;
        }

    }


    public static int run(List<String> args, String compiledPath, String classPath, String mainClass) {
        try {
            ProcessBuilder runBuilder = new ProcessBuilder();
            runBuilder.directory(new File(compiledPath));
            List<String> commands = new ArrayList<>();
            commands.add("java");
            commands.add("-cp");
            commands.add(classPath);
            commands.add(mainClass);
            commands.addAll(args);
            runBuilder.command(commands);

            Process runProcess = runBuilder.start();

            BufferedReader runOutputReader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
            StringBuilder runOutput = new StringBuilder();
            String line;
            while ((line = runOutputReader.readLine()) != null) {
                runOutput.append(line).append("\n");
            }

            BufferedReader runErrorReader = new BufferedReader(new InputStreamReader(runProcess.getErrorStream()));
            StringBuilder runErrors = new StringBuilder();
            while ((line = runErrorReader.readLine()) != null) {
                runErrors.append(line).append("\n");
            }

            int runExitCode = runProcess.waitFor();
            if (runExitCode != 0) {
                logger.severe("Error during execution (exit code " + runExitCode + "):");
                logger.severe(runErrors.toString());
            } else {
                System.out.println("Executed successfully. Output:");
                System.out.println(runOutput);
            }
            return runExitCode;

        } catch (Exception e) {
            logger.severe(e.getMessage());
            return -1;
        }
    }
}
