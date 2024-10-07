package it.mauluk92.java.c5;

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
 * This class contains tests to validate rules about String API and its methods
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class ManipulatingStringTest {
    /**
     * Concatenation obeys three rules:
     * 1) If the operands are both numeric, this means that + is numeric addition
     * 2) If either operand is a string, this means that + is concatenation
     * 3) Expressions is evaluated left to right
     */
    @Test
    @DisplayName("The operator + (plug sign) is overloaded and can mean addition or concatenation in different contexts")
    public void concatenationRules(
            @CompileClasses(classesToCompile = "ConcatenationRules.java", sourcePath = "c5/manipulating_string")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ConcatenationRules")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * This test contains useful methods of String API which get other Strings and do not modify older Strings in place
     */
    @Test
    @DisplayName("String API contains a lot of utility methods for getting new strings from older ones: it is not possible to manipulate string in place due to immutability")
    public void stringMethods(
            @CompileClasses(classesToCompile = "StringMethods.java", sourcePath = "c5/manipulating_string")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "StringMethods")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }


}
