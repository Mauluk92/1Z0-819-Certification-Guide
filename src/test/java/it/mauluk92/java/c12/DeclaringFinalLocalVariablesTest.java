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
 * This class contain tests to validate rules about final local variables
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class DeclaringFinalLocalVariablesTest {

    /**
     * Using uninitialized final local variables
     * raise a compilation error
     */
    @Test
    @DisplayName("Uninitialized final local variables cannot be used")
    public void invalidUsageUninitializedFinalLocalVariables(
            @CompileClasses(classesToCompile = "InvalidUsageUninitializedFinalLocalVariables.java", sourcePath = "c12/declaring_final_local_variables")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Not Using uninitialized final local variables
     * won't raise a compilation error
     */
    @Test
    @DisplayName("Not using uninitialized final local variable won't raise a compilation error")
    public void notUsingUninitializedFinalLocalVariableCompile(
            @CompileClasses(classesToCompile = "NotUsingUninitializedFinalLocalVariableCompile.java", sourcePath = "c12/declaring_final_local_variables")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * A final primitive or reference type can be assigned only once.
     * This means that a primitive cannot change its value
     */
    @Test
    @DisplayName("A primitive final local variable cannot change its value")
    public void primitiveFinalLocalVariableCannotChangeItsValue(
            @CompileClasses(classesToCompile = "PrimitiveFinalLocalVariableCannotChangeItsValue.java", sourcePath = "c12/declaring_final_local_variables")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * State of an object can change even though the reference variable
     * is marked as final
     */
    @Test
    @DisplayName("A reference final local variable can change its state")
    public void referenceFinalLocalVariableCanChangeItsState(
            @CompileClasses(classesToCompile = "ReferenceFinalLocalVariableCanChangeItsState.java", sourcePath = "c12/declaring_final_local_variables")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }
}
