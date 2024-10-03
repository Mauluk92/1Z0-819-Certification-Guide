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
 * This class contains tests to validate the rules for unary operators in java
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UnaryOperatorsTest {

    /**
     * Logical complement reverses the value of a boolean expression
     * It is not applicable to values
     */
    @Test
    @DisplayName("Logical complement flips the boolean value of its operand")
    public void logicalComplement(
            @CompileClasses(classesToCompile = "LogicalComplement.java", sourcePath = "c3/unary_operators")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "LogicalComplement")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Negation operator reverses the sign of a numeric expression
     * Cannot be applied to boolean values
     */
    @Test
    @DisplayName("Negation operators flips the sign of a numeric expression, its operand")
    public void negationOperator(
            @CompileClasses(classesToCompile = "NegationOperator.java", sourcePath = "c3/unary_operators")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "NegationOperator")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Pre-increment and pre-decrement operators apply the operation first
     * then return the new value
     */
    @Test
    @DisplayName("These operators apply an increment/decrement and then return the result")
    public void preIncrementDecrementOperators(
            @CompileClasses(classesToCompile = "PreIncrementDecrementOperators.java", sourcePath = "c3/unary_operators")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "PreIncrementDecrementOperators")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Post-increment and post-decrement operators return the original value and then apply the operation
     */
    @Test
    @DisplayName("These operators returns the original value and then apply an increment/decrement")
    public void postIncrementDecrementOperators(
            @CompileClasses(classesToCompile = "PostIncrementDecrementOperators.java", sourcePath = "c3/unary_operators")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "PostIncrementDecrementOperators")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
