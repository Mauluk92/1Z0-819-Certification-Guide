package it.mauluk92.java.c12;

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
 * This class contain tests to validate rules about static inner classes
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class StaticInnerClassTest {

    /**
     * Static inner class can be instantiated without
     * any reference to the outer class
     */
    @Test
    @DisplayName("Static inner class can be instantiated without outer class reference")
    public void instantiationStaticInnerClass(
            @CompileClasses(classesToCompile = "InstantiationStaticInnerClass.java", sourcePath = "c12/static_inner_class")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "InstantiationStaticInnerClass")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
