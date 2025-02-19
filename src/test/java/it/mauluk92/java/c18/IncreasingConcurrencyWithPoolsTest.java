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
 * This class contain tests to validate rules about using Thread Pools
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class IncreasingConcurrencyWithPoolsTest {

    /**
     * A thread Pool is a group of pre-instantiated reusable
     * threads that are available to perform a set of arbitrary tasks.
     * While a single Thread Executor will wait for a thread to become
     * available, a pooled thread executor can execute the next task concurrently.
     * If the pool runs out of available threads, the task will be queued
     * by the thread executor and wait to be completed.
     * The newFixedThreadPool() takes a number of threads and allocates
     * them all upon creation. As long the number of tasks is less than
     * our number of threads, all tasks will be executed concurrently.
     * Otherwise, they will wait for any thread to become free again
     */
    @Test
    @DisplayName("Fixed thread pool")
    public void fixedThreadPool(
            @CompileClasses(classesToCompile = "FixedThreadPool.java", sourcePath = "c18/increasing_concurrency_with_pools")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "FixedThreadPool")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The newCachedThreadPool() will create a thread pool of unbounded
     * size, allocating a new thread anytime one is required or all
     * executing threads are busy. Strongly discouraged for long-lived
     * processes.
     */
    @Test
    @DisplayName("Cached Thread pool")
    public void cachedThreadPool(
            @CompileClasses(classesToCompile = "CachedThreadPool.java", sourcePath = "c18/increasing_concurrency_with_pools")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CachedThreadPool")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
