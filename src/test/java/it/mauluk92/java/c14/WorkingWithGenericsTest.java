package it.mauluk92.java.c14;

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
 * This class contain tests to validate rules about generics
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class WorkingWithGenericsTest {

    /**
     * The syntax for introducing a generic
     * is to declare a formal type parameter
     * in angle brackets
     */
    @Test
    @DisplayName("Generic classes")
    public void genericClasses(
            @CompileClasses(classesToCompile = "GenericClasses.java", sourcePath = "c14/working_with_generics")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Even interfaces can be declared as generic
     * types, using the same notation of classes
     */
    @Test
    @DisplayName("Generic interfaces")
    public void genericInterfaces(
            @CompileClasses(classesToCompile = "GenericInterfaces.java", sourcePath = "c14/working_with_generics")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Methods can also be declared as generics
     * and accept a formal type parameter
     */
    @Test
    @DisplayName("Generic methods")
    public void genericMethods(
            @CompileClasses(classesToCompile = "GenericMethods.java", sourcePath = "c14/working_with_generics")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "GenericMethods")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Generic types works also with bounds and wildcards
     * Unbounded wildcards accept any data type
     */
    @Test
    @DisplayName("Unbounded wildcards")
    public void unboundedWildcards(
            @CompileClasses(classesToCompile = "UnboundedWildcards.java", sourcePath = "c14/working_with_generics")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Generic types works also with bounds and wildcards
     * Upper bounded wildcards accept any data type that extends
     * the given bound
     */
    @Test
    @DisplayName("Upper bounded wildcards")
    public void upperBoundedWildcards(
            @CompileClasses(classesToCompile = "UpperBoundedWildcards.java", sourcePath = "c14/working_with_generics")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Generic types works also with bounds and wildcards
     * Lower bounded wildcards accept any data type that are superclass of
     * the given bound
     */
    @Test
    @DisplayName("Lower bounded wildcards")
    public void lowerBoundedWildcards(
            @CompileClasses(classesToCompile = "LowerBoundedWildcards.java", sourcePath = "c14/working_with_generics")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
