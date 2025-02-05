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
 * This class contain tests to validate rules about final static variables
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class FinalStaticVariablesTest {

    /**
     * Static variables must be initialized and
     * left uninitialized, will raise a compilation error
     */
    @Test
    @DisplayName("Uninitialized final static variables cannot be used")
    public void invalidUsageUninitializedFinalStaticVariables(
            @CompileClasses(classesToCompile = "InvalidUsageUninitializedFinalStaticVariables.java", sourcePath = "c12/final_static_variables")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
