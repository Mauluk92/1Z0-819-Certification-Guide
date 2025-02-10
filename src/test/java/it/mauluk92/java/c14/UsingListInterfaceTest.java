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
 * This class contain tests to validate rules about using List interface
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UsingListInterfaceTest {

    /**
     * List can be used with different factory methods.
     * The resulting list will be often immutable
     */
    @Test
    @DisplayName("List factory methods")
    public void listFactoryMethods(
            @CompileClasses(classesToCompile = "ListFactoryMethods.java", sourcePath = "c14/using_list_interface")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * A list include method to add a generic element
     * E to the end. There is also a method to add an element in a specified
     * position moving the rest towards the end
     */
    @Test
    @DisplayName("List add methods")
    public void listAddMethod(
            @CompileClasses(classesToCompile = "ListAddMethod.java", sourcePath = "c14/using_list_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ListAddMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * A list include method to get an element
     * from a specified index (get)
     */
    @Test
    @DisplayName("List get method")
    public void listGetMethod(
            @CompileClasses(classesToCompile = "ListGetMethod.java", sourcePath = "c14/using_list_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ListGetMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * A list include method to remove an element
     * from a specified index, moving the rest toward the front
     */
    @Test
    @DisplayName("List remove method")
    public void listRemoveMethod(
            @CompileClasses(classesToCompile = "ListRemoveMethod.java", sourcePath = "c14/using_list_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ListRemoveMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * A list include method to replace all elements
     * specifying a unary operator to apply
     */
    @Test
    @DisplayName("List replaceAll method")
    public void listReplaceAllMethod(
            @CompileClasses(classesToCompile = "ListReplaceAllMethod.java", sourcePath = "c14/using_list_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ListReplaceAllMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * A list include method to set an element
     * specifying the new element and the index
     */
    @Test
    @DisplayName("List set method")
    public void listSetMethod(
            @CompileClasses(classesToCompile = "ListSetMethod.java", sourcePath = "c14/using_list_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ListSetMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * A list can be iterated through an Iterator
     */
    @Test
    @DisplayName("List iterator")
    public void listIterator(
            @CompileClasses(classesToCompile = "ListIterator.java", sourcePath = "c14/using_list_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ListIterator")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Modifying a list while iterating through it will
     * raise a ConcurrentModificationException
     */
    @Test
    @DisplayName("Concurrent Modification Exception")
    public void concurrentModificationException(
            @CompileClasses(classesToCompile = "ConcurrentModificationException.java", sourcePath = "c14/using_list_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ConcurrentModificationException")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertNotEquals(0, outputExecution);
    }


}
