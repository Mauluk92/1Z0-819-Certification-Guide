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
 * This class contain tests to validate rules about default interface methods
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class DefaultInterfaceMethodsTest {

    /**
     * Default methods cannot be used inside regular classes
     */
    @Test
    @DisplayName("Cannot use default modifier inside regular classes")
    public void defaultInterfaceMethodNotAllowedInClasses(
            @CompileClasses(classesToCompile = "DefaultInterfaceMethodNotAllowedInClasses.java", sourcePath = "c12/default_interface_methods")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Default methods must include a body
     */
    @Test
    @DisplayName("Default methods must have a body")
    public void defaultMethodMustHaveBody(
            @CompileClasses(classesToCompile = "DefaultMethodMustHaveBody.java", sourcePath = "c12/default_interface_methods")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Default methods cannot be marked as final
     */
    @Test
    @DisplayName("Default methods cannot be marked final")
    public void defaultMethodsCannotBeMarkedFinal(
            @CompileClasses(classesToCompile = "DefaultMethodsCannotBeMarkedFinal.java", sourcePath = "c12/default_interface_methods")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Default methods cannot be marked as abstract
     */
    @Test
    @DisplayName("Default methods cannot be marked abstract")
    public void defaultMethodsCannotBeMarkedAbstract(
            @CompileClasses(classesToCompile = "DefaultMethodsCannotBeMarkedAbstract.java", sourcePath = "c12/default_interface_methods")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Default methods cannot be marked static
     */
    @Test
    @DisplayName("Default methods cannot be marked static")
    public void defaultMethodsCannotBeMarkedStatic(
            @CompileClasses(classesToCompile = "DefaultMethodsCannotBeMarkedStatic.java", sourcePath = "c12/default_interface_methods")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Default methods can be overridden by class implementing the interface
     */
    @Test
    @DisplayName("Default methods can be overridden")
    public void defaultMethodsCanBeOverridden(
            @CompileClasses(classesToCompile = "DefaultMethodsCanBeOverridden.java", sourcePath = "c12/default_interface_methods")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Class with two implementing interface and same method signature
     * must explicitly override and redefine the method inherited
     */
    @Test
    @DisplayName("Diamond inheritance problem")
    public void diamondInheritanceProblem(
            @CompileClasses(classesToCompile = "DiamondInheritanceProblem.java", sourcePath = "c12/default_interface_methods")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
