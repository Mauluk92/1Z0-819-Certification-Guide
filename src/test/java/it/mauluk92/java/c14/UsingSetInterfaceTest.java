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
 * This class contain tests to validate rules about using Set interface
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UsingSetInterfaceTest {

    /**
     * Set can be used with different factory methods.
     * The resulting set will be often immutable
     */
    @Test
    @DisplayName("Set factory methods")
    public void setFactoryMethods(
            @CompileClasses(classesToCompile = "SetFactoryMethods.java", sourcePath = "c14/using_set_interface")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Set cannot contain duplicate.
     * Elements added are tested against equals of other members
     */
    @Test
    @DisplayName("Set duplicates")
    public void setDuplicates(
            @CompileClasses(classesToCompile = "SetDuplicates.java", sourcePath = "c14/using_set_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "SetDuplicates")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
