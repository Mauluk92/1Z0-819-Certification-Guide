package it.mauluk92.java.c3;

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
 * This class contains tests to validate rules regarding the ternary operator in Java
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class TernaryOperatorTest {

    /**
     * Ternary operator is equivalent to an if/else conditional execution
     */
    @Test
    @DisplayName("This test show that ternary operator is equivalent to if/else")
    public void ternaryOperator(
            @CompileClasses(classesToCompile = "TernaryOperator.java", sourcePath = "c3/ternary_operator")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "TernaryOperator")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
