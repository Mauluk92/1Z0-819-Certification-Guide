package it.mauluk92.java.c10;

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
 * This class contains tests to validate rules about exceptions
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UnderstandingExceptionTest {

    /**
     * Checked exception must be either declared or handled
     * otherwise the compiler will complain
     */
    @Test
    @DisplayName("Checked exceptions must be either be declared or handled")
    public void checkedExceptionMustNotCompile(
            @CompileClasses(classesToCompile = "CheckedExceptionMustNotCompile.java", sourcePath = "c10/understanding_exceptions")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Unchecked exception will compile if not declared or handled
     */
    @Test
    @DisplayName("Unchecked exceptions will compile if not declared or handled")
    public void uncheckedExceptionMustNotCompile(
            @CompileClasses(classesToCompile = "UncheckedExceptionMustCompile.java", sourcePath = "c10/understanding_exceptions")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Exceptions make the code below unreachable
     * and will not compile if any instruction is there
     */
    @Test
    @DisplayName("Exceptions make code unreachable")
    public void exceptionUnreachableCode(
            @CompileClasses(classesToCompile = "ExceptionUnreachableCode.java", sourcePath = "c10/understanding_exceptions")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * This method lists various unchecked exceptions
     * with their description
     */
    @Test
    @DisplayName("Unchecked exception classes")
    public void uncheckedExceptionClasses(
            @CompileClasses(classesToCompile = "UncheckedExceptionClasses.java", sourcePath = "c10/understanding_exceptions")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "UncheckedExceptionClasses")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * This method lists various checked exceptions
     * with their description
     */
    @Test
    @DisplayName("Checked exception classes")
    public void checkedExceptionClasses(
            @CompileClasses(classesToCompile = "CheckedExceptionClasses.java", sourcePath = "c10/understanding_exceptions")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CheckedExceptionClasses")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Errors are unchecked exceptions that extends the Error class
     * They are thrown by the JVM and should not be declared or handled.
     * This method lists various Error classes
     */
    @Test
    @DisplayName("Error exception classes")
    public void errorExceptionClasses(
            @CompileClasses(classesToCompile = "ErrorExceptionClasses.java", sourcePath = "c10/understanding_exceptions")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ErrorExceptionClasses")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }



}
