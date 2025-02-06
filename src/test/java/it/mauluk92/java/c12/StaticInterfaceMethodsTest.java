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
 * This class contain tests to validate rules about static methods in interfaces
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class StaticInterfaceMethodsTest {

    /**
     * Static methods must include a body
     */
    @Test
    @DisplayName("Static methods must have a body inside interfaces")
    public void staticMethodBody(
            @CompileClasses(classesToCompile = "StaticMethodBody.java", sourcePath = "c12/static_interface_methods")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Static methods cannot be declared abstract
     */
    @Test
    @DisplayName("Static methods cannot be marked abstract")
    public void staticMethodMustNotBeAbstract(
            @CompileClasses(classesToCompile = "StaticMethodMustNotBeAbstract.java", sourcePath = "c12/static_interface_methods")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Static methods cannot be declared final
     */
    @Test
    @DisplayName("Static methods cannot be marked final")
    public void staticMethodMustNotBeFinal(
            @CompileClasses(classesToCompile = "StaticMethodMustNotBeFinal.java", sourcePath = "c12/static_interface_methods")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Static methods are not inherited and cannot be called without
     * an explicit reference to the interface
     */
    @Test
    @DisplayName("Static methods are not inherited")
    public void staticMethodsNotInherited(
            @CompileClasses(classesToCompile = "StaticMethodsNotInherited.java", sourcePath = "c12/static_interface_methods")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
