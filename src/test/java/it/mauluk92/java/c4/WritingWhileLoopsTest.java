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
 * This class validates rules regarding while and while/do loops statements
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class WritingWhileLoopsTest {

    /**
     * While statements can be used to repeat any number of statements a certain amount of times, till a condition becomes false
     */
    @Test
    @DisplayName("Class while loop repeat till a condition becomes false")
    public void whileLoops(
            @CompileClasses(classesToCompile = "WhileLoops.java", sourcePath = "c4/writing_while_loops")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "WhileLoops")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Do while loops are similar to while loops, but the condition is evaluated at the end
     */
    @Test
    @DisplayName("Do/While loops evaluates conditions at the end of the loop")
    public void doWhileLoops(
            @CompileClasses(classesToCompile = "DoWhileLoops.java", sourcePath = "c4/writing_while_loops")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "DoWhileLoops")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
