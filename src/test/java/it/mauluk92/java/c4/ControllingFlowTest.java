package it.mauluk92.java.c4;

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
 * This class contains tests to validate controlling flow statements such as continue, break and return statements
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class ControllingFlowTest {

    /**
     * Break statements can interrupt a loop
     */
    @Test
    @DisplayName("Break statements can be inserted in a loop under certain condition to terminate the loop")
    public void breakStatement(
            @CompileClasses(classesToCompile = "BreakStatement.java", sourcePath = "c4/controlling_flow")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "BreakStatement")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Loops can be skipped through the continue statement
     */
    @Test
    @DisplayName("Continue statement can be used to skip loop execution to the next cycle")
    public void continueStatement(
            @CompileClasses(classesToCompile = "ContinueStatement.java", sourcePath = "c4/controlling_flow")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ContinueStatement")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Loops can be interrupted through a return statement
     */
    @Test
    @DisplayName("Returns interrupts a loop")
    public void returnStatement(
            @CompileClasses(classesToCompile = "ReturnStatement.java", sourcePath = "c4/controlling_flow")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ReturnStatement")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Unreachable code causes the compiler to not compile
     */
    @Test
    @DisplayName("Unreachable code makes the compiler complains")
    public void unreachableCode(
            @CompileClasses(classesToCompile = "UnreachableCode.java", sourcePath = "c4/controlling_flow")
            Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Label act as a placeholder for loops, particularly useful in breaking out of nested loops
     */
    @Test
    @DisplayName("Labels can be used to break or skip from outer loops")
    public void loopLabels(
            @CompileClasses(classesToCompile = "LoopLabels.java", sourcePath = "c4/controlling_flow")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "LoopLabels")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

}
