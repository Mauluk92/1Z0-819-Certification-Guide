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
 * This class contain tests to validate rules about using Queue interface
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UsingQueueInterfaceTest {

    /**
     * Queue have an add method that add an element
     * to the back of the queue and returns true
     * of throw an exception if not possible
     *
     */
    @Test
    @DisplayName("Add queue method")
    public void addQueueMethod(
            @CompileClasses(classesToCompile = "AddQueueMethod.java", sourcePath = "c14/using_queue_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "AddQueueMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertNotEquals(0, outputExecution);
    }

    /**
     * Queue have a element method that
     * returns the given element in the queue
     * or throws an exception if queue is empty
     *
     */
    @Test
    @DisplayName("Element queue method")
    public void elementQueueMethod(
            @CompileClasses(classesToCompile = "ElementQueueMethod.java", sourcePath = "c14/using_queue_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ElementQueueMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertNotEquals(0, outputExecution);
    }

    /**
     * Queue have an offer method that
     * adds an element to the back and returns
     * a boolean base on whether the operation is successful
     */
    @Test
    @DisplayName("Offer queue method")
    public void offerQueueMethod(
            @CompileClasses(classesToCompile = "OfferQueueMethod.java", sourcePath = "c14/using_queue_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "OfferQueueMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Queue have a remove method that removes and
     * returns the given element in the queue
     * or throws an exception if queue is empty
     *
     */
    @Test
    @DisplayName("Remove queue method")
    public void removeQueueMethod(
            @CompileClasses(classesToCompile = "RemoveQueueMethod.java", sourcePath = "c14/using_queue_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "RemoveQueueMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertNotEquals(0, outputExecution);
    }

    /**
     * Queue have a poll method that removes and
     * returns the given element in the queue
     * or null if empty queue
     *
     */
    @Test
    @DisplayName("Poll queue method")
    public void pollQueueMethod(
            @CompileClasses(classesToCompile = "PollQueueMethod.java", sourcePath = "c14/using_queue_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "PollQueueMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Queue have a peek method that
     * returns the given element in the queue
     * or null if empty queue
     *
     */
    @Test
    @DisplayName("Peek queue method")
    public void peekQueueMethod(
            @CompileClasses(classesToCompile = "PeekQueueMethod.java", sourcePath = "c14/using_queue_interface")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "PeekQueueMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
