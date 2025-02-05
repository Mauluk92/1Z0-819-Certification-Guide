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
 * This class contain tests to validate rules about final instance variables
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class FinalInstanceVariablesTest {

    /**
     * Using uninitialized final instance variables
     * raise a compilation error
     */
    @Test
    @DisplayName("Uninitialized final instance variables cannot be used")
    public void invalidUsageUninitializedFinalInstanceVariables(
            @CompileClasses(classesToCompile = "InvalidUsageUninitializedFinalInstanceVariables.java", sourcePath = "c12/final_instance_variables")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Instance final variable cannot be initialized
     * more than once
     */
    @Test
    @DisplayName("Final instance variables cannot be initialized more than once")
    public void initializingMoreThanOnceFinalInstanceVariableMustNotCompile(
            @CompileClasses(classesToCompile = "InitializingMoreThanOnceFinalInstanceVariableMustNotCompile.java", sourcePath = "c12/final_instance_variables")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
