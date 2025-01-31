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
 * This class contains tests to validate rules about handling of exceptions
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class HandlingExceptionTest {

    /**
     * Try catch block is used to protect code from "failure"
     * catching exceptions inside try and executing code inside catch
     * block whenever the given exception occurs
     */
    @Test
    @DisplayName("Try catch block syntax")
    public void tryCatchBlock(
            @CompileClasses(classesToCompile = "TryCatchBlock.java", sourcePath = "c10/handling_exceptions")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "TryCatchBlock")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Try catch without a catch block is invalid
     * because try/catch is used to recover from exceptions
     */
    @Test
    @DisplayName("Try catch block invalid syntax")
    public void tryCatchInvalid(
            @CompileClasses(classesToCompile = "TryCatchInvalid.java", sourcePath = "c10/handling_exceptions")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * It is possible to chain multiple catch block
     * in order to catch different kind of exceptions
     */
    @Test
    @DisplayName("Try catch block with multiple catch")
    public void multiCatchBlock(
            @CompileClasses(classesToCompile = "MultipleCatchBlock.java", sourcePath = "c10/handling_exceptions")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * If in a multi-catch block any of the exceptions
     * is unreachable a compilation error is raised
     */
    @Test
    @DisplayName("Multi catch block invalid syntax")
    public void multiCatchBlockInvalid(
            @CompileClasses(classesToCompile = "MultiCatchBlockInvalid.java", sourcePath = "c10/handling_exceptions")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Try catch block may contain a "finally" clause
     * which executes regardless an exception is thrown or not
     */
    @Test
    @DisplayName("Try catch block syntax")
    public void finallyClause(
            @CompileClasses(classesToCompile = "FinallyClause.java", sourcePath = "c10/handling_exceptions")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "FinallyClause")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
