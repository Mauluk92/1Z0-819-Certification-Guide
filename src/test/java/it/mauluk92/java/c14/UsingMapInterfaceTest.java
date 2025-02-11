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
 * This class contain tests to validate rules about using Map interface
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UsingMapInterfaceTest {

    /**
     * Map have a clear method that empties
     * the keys and values stored
     */
    @Test
    @DisplayName("Clear map method")
    public void clearMapMethod(
            @CompileClasses(classesToCompile = "ClearMapMethod.java", sourcePath = "c14/using_map_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ClearMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Map have a containsKey method
     * that check if the given key is keySet
     */
    @Test
    @DisplayName("ContainsKey map method")
    public void containsKeyMapMethod(
            @CompileClasses(classesToCompile = "ContainsKeyMapMethod.java", sourcePath = "c14/using_map_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ContainsKeyMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Map have a containsValue method
     * that check if the given value is in map
     */
    @Test
    @DisplayName("ContainsValue map method")
    public void containsValueMapMethod(
            @CompileClasses(classesToCompile = "ContainsValueMapMethod.java", sourcePath = "c14/using_map_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ContainsValueMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Map have a entrySet method
     * that list all entries inside a map
     */
    @Test
    @DisplayName("EntrySet map method")
    public void entrySetMapMethod(
            @CompileClasses(classesToCompile = "EntrySetMapMethod.java", sourcePath = "c14/using_map_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "EntrySetMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Map have a forEach() method
     * to iterate through keys and values
     */
    @Test
    @DisplayName("ForEach map method")
    public void forEachMapMethod(
            @CompileClasses(classesToCompile = "ForEachMapMethod.java", sourcePath = "c14/using_map_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ForEachMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Map have a get method
     * to get a particular value from a given key
     */
    @Test
    @DisplayName("Get map method")
    public void getMapMethod(
            @CompileClasses(classesToCompile = "GetMapMethod.java", sourcePath = "c14/using_map_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "GetMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Map have a getOrDefault method
     * to get a particular value from a given key
     * or a default if no key was found
     */
    @Test
    @DisplayName("GetOrDefault map method")
    public void getOrDefaultMapMethod(
            @CompileClasses(classesToCompile = "GetOrDefaultMapMethod.java", sourcePath = "c14/using_map_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "GetOrDefaultMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Map have isEmpty method
     * to verify size of Map
     */
    @Test
    @DisplayName("GetOrDefault map method")
    public void isEmptyMapMethod(
            @CompileClasses(classesToCompile = "IsEmptyMapMethod.java", sourcePath = "c14/using_map_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "IsEmptyMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Map have keySet method
     * to get the set of all keys inside a map
     */
    @Test
    @DisplayName("KeySet map method")
    public void keySetMapMethod(
            @CompileClasses(classesToCompile = "KeySetMapMethod.java", sourcePath = "c14/using_map_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "KeySetMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Map have merge method that
     * sets value if not set.  Runs the function
     * if the key is set to determine the new value.
     * Removes if null
     */
    @Test
    @DisplayName("Merge map method")
    public void mergeMapMethod(
            @CompileClasses(classesToCompile = "MergeMapMethod.java", sourcePath = "c14/using_map_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "MergeMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Map have put method to insert
     * a value at a given key.
     * If key already exists, substitute the value.
     * Returns the previous value
     */
    @Test
    @DisplayName("Put map method")
    public void putMapMethod(
            @CompileClasses(classesToCompile = "PutMapMethod.java", sourcePath = "c14/using_map_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "PutMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Map have putIfAbsent method to insert
     * a value at a given key.
     * If key already exists, do nothing and
     * returns the existing value
     */
    @Test
    @DisplayName("PutIfAbsent map method")
    public void putIfAbsentMapMethod(
            @CompileClasses(classesToCompile = "PutIfAbsentMapMethod.java", sourcePath = "c14/using_map_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "PutIfAbsentMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Map have a remove method that
     * returns null if no key exists, otherwise
     * deleted the element and returns the old element
     */
    @Test
    @DisplayName("Remove map method")
    public void removeMapMethod(
            @CompileClasses(classesToCompile = "RemoveMapMethod.java", sourcePath = "c14/using_map_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "RemoveMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Map have a replace method that
     * returns  the original value for the given key if set
     * Otherwise it will do nothing and returns null
     */
    @Test
    @DisplayName("Replace map method")
    public void replaceMapMethod(
            @CompileClasses(classesToCompile = "ReplaceMapMethod.java", sourcePath = "c14/using_map_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ReplaceMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Map have a replaceAll method
     * Replaces each value with the result of function
     */
    @Test
    @DisplayName("ReplaceAll map method")
    public void replaceAllMapMethod(
            @CompileClasses(classesToCompile = "ReplaceAllMapMethod.java", sourcePath = "c14/using_map_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ReplaceAllMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Map have a size method
     * returns the size of the map itself
     */
    @Test
    @DisplayName("Size map method")
    public void sizeMapMethod(
            @CompileClasses(classesToCompile = "SizeMapMethod.java", sourcePath = "c14/using_map_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "SizeMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Map have a values method
     * returns the collection of all values in the map
     */
    @Test
    @DisplayName("Values map method")
    public void valuesMapMethod(
            @CompileClasses(classesToCompile = "ValuesMapMethod.java", sourcePath = "c14/using_map_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ValuesMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
