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
 * This class validates rules of operator == and equals() method
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UnderstandingEqualityTest {


    /**
     * There are actually two different way of comparing objects for equality testing
     * 1) The strict equality operator which checks if two objects are the same
     * 2) The equals method which merely checks that two objects are equals according to a certain
     * criterion. This one is a method inherited by the Object class
     */
    @Test
    @DisplayName("The == operator and equals method are not the same, in general")
    public void comparingDifferentEqualities(
            @CompileClasses(classesToCompile = "ComparingDifferentEqualities.java", sourcePath = "c5/understanding_equality")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ComparingDifferentEqualities")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * String pool make possible string reuse and sharing, which means that some strings
     * may be equal even if they are apparently different objects, because of the way
     * the JVM treats string literals. You can force a creation of a new string out of the string pool
     * by using the operator new, and conversely you can add a string to the pool by using the method
     * intern()
     */
    @Test
    @DisplayName("String pool make possible string reuse and sharing across the program")
    public void stringPool(
            @CompileClasses(classesToCompile = "StringPool.java", sourcePath = "c5/understanding_equality")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "StringPool")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
