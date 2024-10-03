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
 * This class contains tests to validate rules of precedence in Java operators
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class OperatorPrecedenceTest {


    /**
     * Operators have rules of precedence: here are the following rules from the highest precedence
     * Post-unary operators ( a++, b--)
     * Pre-unary operators (++a, --b)
     * Other unary operator (-, +, !, (type) )
     * Multiplication/Division/Modulus
     * Addition/Subtraction
     * Shift operators
     * Relational operators (<=, instanceof)
     * Equal, Not Equal To
     * Logical Operators
     * Short circuit logical operators
     * Ternary operators
     * Assignment operators
     */
    @Test
    @DisplayName("Rules of precedence according to Java specification")
    public void rulesOfPrecedence(
            @CompileClasses(classesToCompile = "RulesOfPrecedence.java", sourcePath = "c3/operator_precedence")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "RulesOfPrecedence")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
