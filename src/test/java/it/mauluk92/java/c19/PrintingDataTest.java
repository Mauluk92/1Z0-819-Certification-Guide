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
 * This class contain tests to validate rules about {@link PrintStream} and {@link PrintWriter}
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class PrintingDataTest {

    /**
     * {@link PrintStream} and {@link PrintWriter} are high level
     * output print stream classes that are useful for writing text data to
     * a stream.
     * The most basic of the print-based methods is print(). The print stream
     * classes include numerous overloaded versions of print which
     * takes everything from primitives adn string values, to objects.
     * Under the covers, these methods often just perform String.valueOf()
     * on the arguments and call the underlying streams' write() method to add it to the
     * stream.
     */
    @Test
    @DisplayName("Print method")
    public void printMethod(
            @CompileClasses(classesToCompile = "PrintMethod.java", sourcePath = "c19/printing_data")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "PrintMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The next methods available in the PrintStream and PrintWriter classes
     * are the println() methods, which are virtually identical to the print()
     * methods except that they also print a line break after the string
     * value is written. These PrintStream classes also include a no-argument version
     * of println() which just prints a single line-break
     */
    @Test
    @DisplayName("Println method")
    public void printlnMethod(
            @CompileClasses(classesToCompile = "PrintlnMethod.java", sourcePath = "c19/printing_data")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "PrintlnMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Each PrintStream classes includes a format() method, which includes
     * an overloaded version that takes a Locale. The method parameters are used to
     * construct a formatted String in a single method call, rather than via a lot
     * of format and concatenation operations. They return a reference to the instance
     * they are called on so that operations can be chained together.
     */
    @Test
    @DisplayName("Format method")
    public void formatMethod(
            @CompileClasses(classesToCompile = "FormatMethod.java", sourcePath = "c19/printing_data")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "FormatMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
