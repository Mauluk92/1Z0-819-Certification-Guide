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
 * This class contain tests to validate rules about final methods
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class WritingFinalMethodTest {

    /**
     * Final methods cannot be overridden
     */
    @Test
    @DisplayName("Final methods cannot be overridden")
    public void finalMethodsCannotBeOverridden(
            @CompileClasses(classesToCompile = "FinalMethodsCannotBeOverridden.java", sourcePath = "c12/writing_final_methods")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Final and abstract modifier are incompatible on a method
     */
    @Test
    @DisplayName("Final methods cannot be abstract")
    public void finalMethodCannotBeAbstract(
            @CompileClasses(classesToCompile = "FinalMethodCannotBeAbstract.java", sourcePath = "c12/writing_final_methods")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
