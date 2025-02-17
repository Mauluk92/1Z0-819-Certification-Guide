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
public class CreatingCustomExceptionTest {

    /**
     * When creating your own exception, you need to decide
     * whether it should be a checked or unchecked exception.
     * While you can extend any exception class, it is not
     * common to extend Exception (for checked) or RuntimeException
     * (for unchecked)
     */
    @Test
    @DisplayName("Extending exceptions")
    public void extendingExceptions(
            @CompileClasses(classesToCompile = "ExtendingExceptions.java", sourcePath = "c16/creating_custom_exception")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Using different constructors in exception classes allows
     * you to provide more information about what went wrong
     */
    @Test
    @DisplayName("Adding custom constructors")
    public void addingCustomConstructors(
            @CompileClasses(classesToCompile = "AddingCustomConstructors.java", sourcePath = "c16/creating_custom_exception")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * The error messages to show are called stack traces.
     * A stack trace shows the exception along with the method calls
     * it took to get there. The JVM automatically prints a stack trace
     * when an exception is thrown that is not handled by the program
     */
    @Test
    @DisplayName("Printing the stack trace")
    public void printingStackTraces(
            @CompileClasses(classesToCompile = "PrintingStackTraces.java", sourcePath = "c16/creating_custom_exception")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "PrintingStackTraces")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
