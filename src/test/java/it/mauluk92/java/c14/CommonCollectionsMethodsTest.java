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
 * This class contain tests to validate rules about using methods from Collection interface
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class CommonCollectionsMethodsTest {

    /**
     * Add method in collection interface is used
     * to add an element. Returns true if operation
     * is successful, false otherwise
     */
    @Test
    @DisplayName("Add method in Collection interface")
    public void addMethodCollectionInterface(
            @CompileClasses(classesToCompile = "AddMethodCollectionInterface.java", sourcePath = "c14/common_collections_methods")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "AddMethodCollectionInterface")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Remove method in collection interface is used
     * to remove an element. Returns true if operation
     * is successful, false otherwise
     */
    @Test
    @DisplayName("Remove method in Collection interface")
    public void removeMethodCollectionInterface(
            @CompileClasses(classesToCompile = "RemoveMethodCollectionInterface.java", sourcePath = "c14/common_collections_methods")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "RemoveMethodCollectionInterface")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * IsEmpty or size methods are useful to check
     * how many elements are in a Collection
     */
    @Test
    @DisplayName("IsEmpty or size methods in Collection")
    public void isEmptySizeMethodsCollectionInterface(
            @CompileClasses(classesToCompile = "IsEmptySizeMethodsCollectionInterface.java", sourcePath = "c14/common_collections_methods")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "IsEmptySizeMethodsCollectionInterface")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Clear method empties the given Collection
     * removing any element if present
     */
    @Test
    @DisplayName("Clear method in Collection interface")
    public void clearMethodCollectionInterface(
            @CompileClasses(classesToCompile = "ClearMethodCollectionInterface.java", sourcePath = "c14/common_collections_methods")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ClearMethodCollectionInterface")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Contains checks if any element inside collection
     * is equal to another element and returns true, false otherwise
     */
    @Test
    @DisplayName("Contains method in Collection interface")
    public void containsMethodCollectionInterface(
            @CompileClasses(classesToCompile = "ContainsMethodCollectionInterface.java", sourcePath = "c14/common_collections_methods")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ContainsMethodCollectionInterface")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * RemoveIf checks if any element inside collection
     * satisfy a given Predicate and, if so, removes it from Collection
     */
    @Test
    @DisplayName("RemoveIf method in Collection interface")
    public void removeIfMethodCollectionInterface(
            @CompileClasses(classesToCompile = "RemoveIfMethodCollectionInterface.java", sourcePath = "c14/common_collections_methods")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "RemoveIfMethodCollectionInterface")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Foreach applies a consumer to each elements inside a Collection
     */
    @Test
    @DisplayName("ForEach method in Collection interface")
    public void forEachMethodCollectionInterface(
            @CompileClasses(classesToCompile = "ForEachMethodCollectionInterface.java", sourcePath = "c14/common_collections_methods")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ForEachMethodCollectionInterface")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }


}
