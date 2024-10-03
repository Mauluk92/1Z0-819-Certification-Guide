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
 * This class contains tests to validate rules about binary arithmetic operators
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class BinaryArithmeticOperatorsTest {

    /**
     * Classic arithmetic operators are included in Java
     */
    @Test
    @DisplayName("Java includes operators from classic arithmetic")
    public void basicArithmeticOperators(
            @CompileClasses(classesToCompile = "BasicArithmeticOperators.java", sourcePath = "c3/binary_arithmetic_operators")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "BasicArithmeticOperators")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Modulus expresses the remainder from a division operation
     */
    @Test
    @DisplayName("Modulus operator is the integer remainder of integer division")
    public void modulusOperator(
            @CompileClasses(classesToCompile = "ModulusOperator.java", sourcePath = "c3/binary_arithmetic_operators")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ModulusOperator")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
