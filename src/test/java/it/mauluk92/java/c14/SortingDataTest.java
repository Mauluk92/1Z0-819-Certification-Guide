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
 * This class contain tests to validate rules about sorting objects
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class SortingDataTest {

    /**
     * Comparable interface can be used to create
     * a natural ordering between objects of a class
     * implementing the given interface
     */
    @Test
    @DisplayName("Creating a comparable class")
    public void creatingComparableClass(
            @CompileClasses(classesToCompile = "CreatingComparableClass.java", sourcePath = "c14/sorting_data_test")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CreatingComparableClass")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * We can also sort objects of a class
     * that does not implement the comparable interface.
     * We can use a Comparator interface in such a case
     */
    @Test
    @DisplayName("Using Comparator interface")
    public void usingComparatorInterface(
            @CompileClasses(classesToCompile = "UsingComparatorInterface.java", sourcePath = "c14/sorting_data_test")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "UsingComparatorInterface")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * We can also sort objects of a class
     * building a Comparator with helper
     * static building methods of the Comparator
     * interface
     */
    @Test
    @DisplayName("Using Comparator static methods")
    public void usingComparatorStaticMethods(
            @CompileClasses(classesToCompile = "UsingComparatorStaticMethods.java", sourcePath = "c14/sorting_data_test")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * We can also sort objects of a class
     * building a Comparator with helper
     * default building methods of the Comparator
     * interface
     */
    @Test
    @DisplayName("Using Comparator default methods")
    public void usingComparatorDefaultMethods(
            @CompileClasses(classesToCompile = "UsingComparatorDefaultMethods.java", sourcePath = "c14/sorting_data_test")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }
}
