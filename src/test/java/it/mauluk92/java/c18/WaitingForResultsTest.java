package it.mauluk92.java.c18;

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
 * This class contain tests to validate rules about waiting for result inside threads
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class WaitingForResultsTest {

    /**
     * How do we know when a task submitted to an ExecutorService is complete?
     * The submit method() returns a {@link java.util.concurrent.Future}
     * instance. The Future type is actually an interface
     */
    @Test
    @DisplayName("Future methods")
    public void futureMethods(
            @CompileClasses(classesToCompile = "FutureMethods.java", sourcePath = "c18/waiting_for_results")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * The Future.get() method can take an optional value
     * and enum type {@link java.util.concurrent.TimeUnit}.
     * Numerous methods in the Concurrency API use the TimeUnit enum
     */
    @Test
    @DisplayName("TimeUnit enum")
    public void timeUnitEnum(
            @CompileClasses(classesToCompile = "TimeUnitEnum.java", sourcePath = "c18/waiting_for_results")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * The {@link java.util.concurrent.Callable} functional
     * interface is similar to Runnable except that its call()
     * method returns a value and can throw a checked exception.
     */
    @Test
    @DisplayName("Callable functional interface")
    public void callableFunctionalInterface(
            @CompileClasses(classesToCompile = "CallableFunctionalInterface.java", sourcePath = "c18/waiting_for_results")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CallableFunctionalInterface")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * After submitting a set of tasks to a thread executor,
     * it is common to wait for the results. One solution is to call
     * get() on each Future object returned by the submit() method.
     * If we don't need the results of the tasks, and we are finished
     * using the thread executor, there is a simpler approach.
     * First, we shut down the thread executor using the shutdown() method.
     * Next, we use awaitTermination() method available for all thread Executor.
     * The method waits the specified time to complete
     * all tasks, returning sooner if all tasks finish or an InterruptedException
     * is detected.
     */
    @Test
    @DisplayName("AwaitTermination method")
    public void awaitTerminationMethod(
            @CompileClasses(classesToCompile = "AwaitTerminationMethod.java", sourcePath = "c18/waiting_for_results")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "AwaitTerminationMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * invokeAll() and invokeAny(), both of these methods execute
     * synchronously and take a collection of tasks. These method will wait
     * until the results are available before returning control to the enclosing
     * program. On the other hand, the invokeAny() method executes
     * a collection of tasks and returns the result of one of the tasks
     * that successfully completes execution, cancelling all unfinished tasks.
     */
    @Test
    @DisplayName("Submitting task collections")
    public void submittingTaskCollections(
            @CompileClasses(classesToCompile = "SubmittingTaskCollections.java", sourcePath = "c18/waiting_for_results")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "SubmittingTaskCollections")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
