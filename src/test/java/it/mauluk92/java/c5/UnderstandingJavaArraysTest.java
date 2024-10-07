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
 * This class contains tests to validate the use of java arrays
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UnderstandingJavaArraysTest {

    /**
     * Arrays can be created in different ways: classic declaration, specifying the values of array during initialization of array variable
     * and using an anonymous array
     */
    @Test
    @DisplayName("Different initialization methods for arrays")
    public void creatingArrays(
            @CompileClasses(classesToCompile = "CreatingArrays.java", sourcePath = "c5/understanding_java_arrays")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CreatingArrays")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
