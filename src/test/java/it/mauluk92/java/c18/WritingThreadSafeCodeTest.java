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
 * This class contain tests to validate rules about writing thread safe code
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class WritingThreadSafeCodeTest {

    /**
     * Thread safety is the property of an object that guarantees
     * safe execution by a multiple threads at the same time.
     * Since threads run in a shared environment and memory space, how do we
     * prevent two threads from interfering with each other?
     * We must organize access to data so that we don't end up
     * with invalid or unexpected result.
     * The unexpected result of two tasks executing at the same time
     * is referred to as a <em>race condition</em>.
     */
    @Test
    @DisplayName("Race condition example")
    public void raceCondition(
            @CompileClasses(classesToCompile = "RaceCondition.java", sourcePath = "c18/writing_thread_safe_code")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "RaceCondition")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertNotEquals(0, outputExecution);
    }

    /**
     * One way to improve concurrent programs is to use
     * Atomic classes. Atomic is the property of an operation
     * to be carved out as a single unit of execution without
     * any references by another thread. A thread safe atomic version of
     * the increment operator would be one that perform the read and write
     * of the variable as a single, indivisible operation, not
     * allowing other threads to access the variable during the operation.
     * The Concurrency API includes numerous atomic wrappers that
     * are conceptually the same as our common primitives classes
     * but that support atomic operations
     */
    @Test
    @DisplayName("Atomic primitive wrappers")
    public void atomicWrapper(
            @CompileClasses(classesToCompile = "AtomicWrapper.java", sourcePath = "c18/writing_thread_safe_code")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "AtomicWrapper")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Where atomic classes are great at protecting single variables, they
     * aren't particularly useful if you need to execute a series of commands
     * or call a method. How do we improve the results so that each worker
     * is able to increment and report the results in order?
     * The most common technique is to use a <em>monitor</em>, also
     * called a lock, to synchronize access. A monitor is a structure that supports
     * mutual exclusion, which is the property that at most one thread is executing
     * a particular segment of code at a given time.
     * In Java, any object can be a monitor, along with the synchronized block.
     * This is referred as a synchronized block. Each thread that arrives will first check
     * if any thread are in the block. In this manner, a thread <em>acquires the lock</em>
     * for the monitor. If the lock is available, a single thread will enter
     * the block, acquiring the lock and preventing all other threads from entering.
     * Once a thread finishes executing the block, it will release the lock.
     */
    @Test
    @DisplayName("Synchronized block")
    public void synchronizedBlock(
            @CompileClasses(classesToCompile = "SynchronizedBlock.java", sourcePath = "c18/writing_thread_safe_code")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "SynchronizedBlock")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
