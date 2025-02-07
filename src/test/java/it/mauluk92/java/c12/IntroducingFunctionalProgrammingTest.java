package it.mauluk92.java.c12;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contain tests to validate rules about functional programming
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class IntroducingFunctionalProgrammingTest {

    /**
     * A functional interface is an interface
     * with a single abstract method (SAM)
     */
    @Test
    @DisplayName("A functional interface is an interface with a single abstract method")
    public void invalidFunctionalInterface(
            @CompileClasses(classesToCompile = "InvalidFunctionalInterface.java", sourcePath = "c12/introducing_functional_programming")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * An interface can override and redefine Object inherited methods
     * and still be a valid functional interface
     */
    @Test
    @DisplayName("Object inherited methods do not count for a functional interface")
    public void validFunctionalInterfaceWithObjectMethods(
            @CompileClasses(classesToCompile = "ValidFunctionalInterfaceWithObjectMethods.java", sourcePath = "c12/introducing_functional_programming")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Any functional interface can be implemented as a lambda expression
     */
    @Test
    @DisplayName("Functional interfaces can be implemented by writing lambda in their place")
    public void lambdaExpressionInPlaceOfFunctionalInterface(
            @CompileClasses(classesToCompile = "LambdaExpressionInPlaceOfFunctionalInterface.java", sourcePath = "c12/introducing_functional_programming")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Lambda expression have a required syntax
     * and an optional syntax
     */
    @Test
    @DisplayName("Lambda expression syntax")
    public void lambdaExpressionSyntax(
            @CompileClasses(classesToCompile = "LambdaExpressionSyntax.java", sourcePath = "c12/introducing_functional_programming")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Lambda expression include the use of var but must
     * be used for all parameters
     */
    @Test
    @DisplayName("Lambda expression syntax")
    public void varLambdaVariableSyntax(
            @CompileClasses(classesToCompile = "VarLambdaVariableSyntax.java", sourcePath = "c12/introducing_functional_programming")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Lambda expression may include local variable declaration its body block
     **/
    @Test
    @DisplayName("Local variable declaration")
    public void localVariableDeclaration(
            @CompileClasses(classesToCompile = "LocalVariableDeclaration.java", sourcePath = "c12/introducing_functional_programming")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Inside lambda local variables from outside can be referenced
     * provided that these are final or effectively final variables
     **/
    @Test
    @DisplayName("Referencing variables from the lambada body")
    public void referencingOutsideVariables(
            @CompileClasses(classesToCompile = "ReferencingOutsideVariables.java", sourcePath = "c12/introducing_functional_programming")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
