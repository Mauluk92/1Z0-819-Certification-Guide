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
 * This class contain tests to validate rules about private static interface methods
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class PrivateStaticInterfaceMethodsTest {

    /**
     * Private static interface methods must have a body
     */
    @Test
    @DisplayName("Private static interface methods must have a body")
    public void privateStaticInterfaceMethodMustHaveBody(
            @CompileClasses(classesToCompile = "PrivateStaticInterfaceMethodMustHaveBody.java", sourcePath = "c12/private_static_interface_methods")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Private static interface methods can only be called from methods within the interface
     */
    @Test
    @DisplayName("Private static interface methods can only be called from methods within the interface")
    public void privateStaticInterfaceMethodsCannotBeCalledOutsideInterface(
            @CompileClasses(classesToCompile = "PrivateStaticInterfaceMethodsCannotBeCalledOutsideInterface.java", sourcePath = "c12/private_static_interface_methods")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

}
