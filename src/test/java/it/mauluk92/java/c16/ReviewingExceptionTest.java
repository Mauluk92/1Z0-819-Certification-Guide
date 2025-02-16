package it.mauluk92.java.c16;

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
 * This class contain tests to validate rules about exceptions and handling exceptions
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class ReviewingExceptionTest {

    /**
     * A try statement is used to handle exceptions.
     * It consists of a try clause, zero or more catch
     * clause, optional finally clause, which runs
     * regardless of whether an exception is thrown
     */
    @Test
    @DisplayName("Structure of a try statement")
    public void handlingExceptions(
            @CompileClasses(classesToCompile = "HandlingExceptions.java", sourcePath = "c16/reviewing_exception")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * You can also create a try with resources statement
     * to handle exceptions. A try with resource statement looks
     * a lot like a try statement, except that includes
     * a list of resources inside a set of parentheses.
     * These resources are automatically closed in reverse
     * order that they are declared at the conclusion of the try clause
     */
    @Test
    @DisplayName("Structure of a try with resource statement")
    public void handlingResources(
            @CompileClasses(classesToCompile = "HandlingResources.java", sourcePath = "c16/reviewing_exception")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "HandlingResources")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The throw keyword means an exception
     * is actually being thrown, while the throws
     * keyword indicates that the method
     * merely has the potential throw that exception
     */
    @Test
    @DisplayName("Throw and throws clause")
    public void throwAndThrows(
            @CompileClasses(classesToCompile = "ThrowAndThrows.java", sourcePath = "c16/reviewing_exception")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * The checked exception must be handled or declared
     * by the application code where it is thrown.
     * The handle or declare rule dictates that checked exception
     * must be either caught in a catch block or thrown to the caller by including it
     * in the method declaration
     */
    @Test
    @DisplayName("Checked exception. Handle or declare rule")
    public void handleOrDeclareRule(
            @CompileClasses(classesToCompile = "HandleOrDeclareRule.java", sourcePath = "c16/reviewing_exception")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * An unchecked exception does not need to be handled
     * or declared. Unchecked exceptions are often referred to
     * as runtime exceptions, although in Java unchecked exceptions
     * include any class that inherits RuntimeException or Error.
     * An error is fatal, and it is considered a poor practice to
     * catch it.
     */
    @Test
    @DisplayName("Unchecked exception. Handle or declare rule does not hold")
    public void uncheckedExceptions(
            @CompileClasses(classesToCompile = "UncheckedException.java", sourcePath = "c16/reviewing_exception")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * This test includes a list of common
     * unchecked exceptions
     */
    @Test
    @DisplayName("List of unchecked exceptions")
    public void uncheckedExceptionsList(
            @CompileClasses(classesToCompile = "UncheckedExceptionsList.java", sourcePath = "c16/reviewing_exception")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "UncheckedExceptionsList")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * This test includes a list of
     * checked exceptions
     */
    @Test
    @DisplayName("List of checked exceptions")
    public void checkedExceptionsList(
            @CompileClasses(classesToCompile = "CheckedExceptionsList.java", sourcePath = "c16/reviewing_exception")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CheckedExceptionsList")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Listing a broader and specific exception which is a subclass
     * of the first exception type is redundant and results
     * in a compilation error
     */
    @Test
    @DisplayName("Redundant multi-catch expression")
    public void redundantMultiCatchExpression(
            @CompileClasses(classesToCompile = "RedundantMultiCatchExpression.java", sourcePath = "c16/reviewing_exception")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Trying to catch a more specific exception results
     * in an unreachable code and a compiler error
     */
    @Test
    @DisplayName("Unreachable catch block")
    public void unreachableCatchBlock(
            @CompileClasses(classesToCompile = "UnreachableCatchBlock.java", sourcePath = "c16/reviewing_exception")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
