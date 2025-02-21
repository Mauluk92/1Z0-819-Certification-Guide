package it.mauluk92.java.c19;

import java.io.*;
import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import it.mauluk92.java.testutils.extension.annotation.ExecuteJavaProgram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contain tests to validate rules about I/O classes with binary and character based data
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class WorkingWithStreamClassesTest {

    /**
     * The first classes that we are going to discuss in detail are the most basic
     * files stream classes, {@link FileInputStream} and {@link FileOutputStream}.
     * They are used to read bytes from a file or write bytes to a file, respectively.
     */
    @Test
    @DisplayName("FileInputStream and FileOutputStream")
    public void fileStreamClasses(
            @CompileClasses(classesToCompile = "FileStreamClasses.java", sourcePath = "c19/working_with_stream_classes")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "FileStreamClasses", classPath = "c19/working_with_stream_classes/files_test")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * There's a cost with each round-trip to the filesystem. We can easily enhance
     * our implementation using {@link BufferedInputStream} amd {@link BufferedOutputStream}
     */
    @Test
    @DisplayName("Buffered binary streams")
    public void bufferedBinaryStreams(
            @CompileClasses(classesToCompile = "BufferedBinaryStreams.java", sourcePath = "c19/working_with_stream_classes")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "BufferedBinaryStreams", classPath = "c19/working_with_stream_classes/files_test")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * {@link FileReader} and {@link FileWriter} classes, along with their
     * associated buffer classes, are among the most convenient I/O classes
     * because of their built-in support for textual data.
     */
    @Test
    @DisplayName("Textual I/O streams")
    public void textualIOStreams(
            @CompileClasses(classesToCompile = "TextualIOStreams.java", sourcePath = "c19/working_with_stream_classes")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "TextualIOStreams", classPath = "c19/working_with_stream_classes/files_test")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
