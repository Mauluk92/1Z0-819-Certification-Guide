package it.mauluk92.java.c7;

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
 * This class contains test to validate rules about passing by value on both primitives and reference types in Java
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class PassingByValueTest {

    /**
     * Since Java is a pass-by-value language,
     * A copy of the data is given to any method
     */
    @Test
    @DisplayName("Method parameters receives a copy of the value, not the value itself")
    public void passByValue(
            @CompileClasses(classesToCompile = "PassByValue.java", sourcePath = "c7/pass_by_value")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "PassByValue")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The same behavior hold for reference types
     * but since the value being copied is actually a reference,
     * any modifications on the object is propagated through all references
     */
    @Test
    @DisplayName("Method parameters receives a copy of the value, not the value itself. In case of reference types, this value is the reference itself")
    public void passByValueReferences(
            @CompileClasses(classesToCompile = "PassByValueReferences.java", sourcePath = "c7/pass_by_value")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "PassByValueReferences")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
