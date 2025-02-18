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
 * This class contain tests to validate rules and structure of threads
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class IntroducingThreadsTest {

    /**
     * A thread is the smallest unit of execution that can be scheduled
     * by the operating system. A process is a group of associated threads
     * that executes in the same, shared environment.
     * It follows, then, that a single threaded process is one
     * that contains exactly one thread, while a multi threaded process
     * contains one or more threads.
     * By shared environment, we mean that
     * the threads in the same process share the same memory space and can communicate
     * directly with one another.
     * A task is a single unit of work performed by a thread. A task will be commonly implemented
     * by a lambda expression. A thread can complete multiple independent tasks but only
     * at a time
     */
    @Test
    @DisplayName("Anatomy of a thread, including process and tasks")
    public void threadAnatomy(
            @CompileClasses(classesToCompile = "ThreadAnatomy.java", sourcePath = "c18/introducing_threads")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ThreadAnatomy")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The property of executing multiple threads and processes
     * at the same time is referred to as concurrency.
     * Operating systems use a thread scheduler to determine which
     * threads should be currently executing. For example, a thread
     * scheduler may employ a round-robin schedule in which each
     * available thread receives an equal number of CPU cycles with which
     * to execute, with threads visited in a circular order.
     * When a thread's allotted time is complete but the thread has not
     * finished processing, a context switch occurs. A context switch is the process
     * of storing a thread's current state and later restoring the state
     * of the thread to continue processing
     */
    @Test
    @DisplayName("Context swwitch in thread scheduler")
    public void concurrencyExample(
            @CompileClasses(classesToCompile = "ConcurrencyExample.java", sourcePath = "c18/introducing_threads")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ConcurrencyExample")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * {@link Runnable} is a functional interface that takes
     * no arguments and returns no data. The Runnable interface is used
     * commonly to define the task or work a Thread will execute,
     * separate from the main application thread.
     */
    @Test
    @DisplayName("Defining a task with Runnable")
    public void definingTaskWithRunnable(
            @CompileClasses(classesToCompile = "DefiningTaskWithRunnable.java", sourcePath = "c18/introducing_threads")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "DefiningTaskWithRunnable")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The simplest way to execute a thread is by using
     * the {@link Thread} class. Executing a task with
     * Thread is a two-step process. First, you define the thread
     * with the corresponding task to be done. Then you start the thread
     * with Thread.start() method. Java does not provide any
     * guarantee about the order in which a thread will be processed
     * once it is started
     */
    @Test
    @DisplayName("Creating a thread")
    public void creatingAThread(
            @CompileClasses(classesToCompile = "CreatingAThread.java", sourcePath = "c18/introducing_threads")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CreatingAThread")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Even though multi-threaded programming allows you to execute
     * multiple tasks at the same time, one thread often needs to wait
     * for the result of another thread to proceed. One solution is to
     * use polling. Polling is the process of intermittently checking
     * data at some fixed interval. In this case, polling is implemented
     * through Thread.sleep() method.
     */
    @Test
    @DisplayName("Thread polling implementation with sleep")
    public void threadPolling(
            @CompileClasses(classesToCompile = "ThreadPolling.java", sourcePath = "c18/introducing_threads")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ThreadPolling")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
