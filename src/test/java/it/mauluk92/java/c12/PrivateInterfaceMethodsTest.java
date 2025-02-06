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
 * This class contain tests to validate rules about private interface methods
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class PrivateInterfaceMethodsTest {

    /**
     * Private interface methods must have a body
     */
    @Test
    @DisplayName("Private interface methods must have a body")
    public void privateInterfaceMethodMustHaveBody(
            @CompileClasses(classesToCompile = "PrivateInterfaceMethodMustHaveBody.java", sourcePath = "c12/private_interface_methods")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Private interface methods cannot be used by static methods
     */
    @Test
    @DisplayName("Private methods cannot be accessed by static methods")
    public void privateInterfaceMethodCannotBeAccessedFromStatic(
            @CompileClasses(classesToCompile = "PrivateInterfaceMethodCannotBeAccessedFromStatic.java", sourcePath = "c12/private_interface_methods")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
