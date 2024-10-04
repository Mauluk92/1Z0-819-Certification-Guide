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

@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class ConstructingForLoopsTest {

    /**
     * For loops are similar to while loops, but include initialization blocks and update statements
     */
    @Test
    @DisplayName("For loops are similar to while loops: it allows to execute a block of statements a certain number of times")
    public void forLoops(
            @CompileClasses(classesToCompile = "ForLoops.java", sourcePath = "c4/constructing_for_loops")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ForLoops")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Initialization blocks in for statements can redefine a local variable inside the loop
     */
    @Test
    @DisplayName("Initialization blocks can redefine variables outside the for block statement")
    public void forLoopsRedefiningVariablesOutside(
            @CompileClasses(classesToCompile = "ForLoopsRedefiningVariablesOutside.java", sourcePath = "c4/constructing_for_loops")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ForLoopsRedefiningVariablesOutside")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Initialization blocks in for statements can initialize more than one variable, and the same holds for update statements
     */
    @Test
    @DisplayName("More than one variable can be defined in initialization blocks and update statements can be more than one")
    public void forLoopsMultipleInitializations(
            @CompileClasses(classesToCompile = "ForLoopsMultipleInitializations.java", sourcePath = "c4/constructing_for_loops")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ForLoopsMultipleInitializations")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * For each loop can be used as a shorthand to iterate on arrays and Iterable objects
     */
    @Test
    @DisplayName("Arrays and Iterable objects can be used inside for each loops")
    public void forEachLoop(
            @CompileClasses(classesToCompile = "ForEachLoop.java", sourcePath = "c4/constructing_for_loops")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ForEachLoop")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
