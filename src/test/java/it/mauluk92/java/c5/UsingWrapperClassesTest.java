package it.mauluk92.java.c5;

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
 * This class validates the rules about auto-boxing, unboxing and wrapper class API in Java
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UsingWrapperClassesTest {


    /**
     * Wrappers have many advantages over their primitive counterparts: but they can also be easily converted into
     * one another by Java, using auto-boxing and un-boxing, although unboxing a null value will produce a
     * NullPointerException as we'll see
     */
    @Test
    @DisplayName("Wrappers act as object version of the primitive types: as such they admit a null value")
    public void usingWrappers(
            @CompileClasses(classesToCompile = "UsingWrappers.java", sourcePath = "c5/using_wrapper_classes")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "UsingWrappers") Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertNotEquals(0, outputExecution);
    }
}
