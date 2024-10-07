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
 * This class contains tests to show the StringBuilder API as a mutable alternative to the String class
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UsingStringBuilderTest {

    /**
     * StringBuilder is used whenever we need to build strings out of many strings at runtime
     * making the process more efficient, without creating each time a new different object
     */
    @Test
    @DisplayName("StringBuilder class act as a mutable version of String class")
    public void stringBuilderMethods(
            @CompileClasses(classesToCompile = "StringBuilderMethods.java", sourcePath = "c5/using_string_builder")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "StringBuilderMethods")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }


}
