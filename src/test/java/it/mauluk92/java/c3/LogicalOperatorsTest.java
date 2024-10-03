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
 * This class contains tests to validate the rules regarding logical operators and short circuit logical
 * operators
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class LogicalOperatorsTest {

    /**
     * Short-circuit logical operators are not evaluated when globally the expression is already determined by previous operands
     * For example: A AND B is true if and only if both A and B are true. The short-circuit and operator (&&) will evaluate
     * the first value and, if false, won't proceed to evaluate the second expression B.
     */
    @Test
    @DisplayName("Short circuit expression can be used to avoid null pointer exception")
    public void logicalOperatorsNullPointer(
            @CompileClasses(classesToCompile = "LogicalOperatorsNullPointer.java", sourcePath = "c3/logical_operators")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "LogicalOperatorsNullPointer")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation); // The code will compile successfully
        Assertions.assertNotEquals(0, outputExecution); // But won't execute: a NullPointerException will be raised at runtime
    }


}
