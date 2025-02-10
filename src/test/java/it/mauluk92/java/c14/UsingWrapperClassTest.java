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
 * This class contain tests to validate rules about using wrapper classes
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UsingWrapperClassTest {

    /**
     * Wrapper classes can be used in place of primitive
     * data types
     */
    @Test
    @DisplayName("Wrapper classes of primitives")
    public void wrapperClasses(
            @CompileClasses(classesToCompile = "WrapperClasses.java", sourcePath = "c14/using_wrapper_class")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * With autoboxing, the compiler converts a primitive
     * into the corresponding wrapper class.
     * With auto-unboxing happens the reverse
     */
    @Test
    @DisplayName("Autoboxing and auto-unboxing")
    public void autoboxingAndAutoUnboxing(
            @CompileClasses(classesToCompile = "AutoboxingAndAutoUnboxing.java", sourcePath = "c14/using_wrapper_class")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "AutoboxingAndAutoUnboxing")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertNotEquals(0, outputExecution);
    }
}
