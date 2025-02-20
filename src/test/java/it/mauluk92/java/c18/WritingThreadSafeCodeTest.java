package it.mauluk92.java.c18;
import java.util.concurrent.locks.*;
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

    /**
     * A synchronized block supports only a limited set of
     * functionality. For example what if we want to check whether
     * a lock is available and, if it is not, perform some other tasks?
     * The concurrency API includes the {@link Lock} interface. That is
     * conceptually similar using the synchronized keyword, but with a lot
     * more functionality. Instead of synchronizing any object, we can
     * lock only an object that implements the Lock interface.
     * Using the Lock interface is pretty easy.
     * When you need to protect a piece of code from multithreaded processing,
     * create an instance of Lock that all threads have access to.
     * Each one call lock before it enters the protected code and calls unlock()
     * before it exits.
     */
    @Test
    @DisplayName("Lock interface")
    public void lockInterface(
            @CompileClasses(classesToCompile = "LockInterface.java", sourcePath = "c18/writing_thread_safe_code")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "LockInterface")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * While the reentrant lock class allows you to wait
     * for a lock, it so far suffers the same problem as a
     * synchronized block. A thread could end up waiting
     * forever to obtain a lock. Luckily includes two additional methods
     * that make the lock interface a lot safer to use than a
     * synchronized block. The Lock maintains a counter of the
     * number of times a lock has been given to a thread.
     * To release the Lock for other to use, unlock() must be called
     * the same number of times the lock has been granted!
     */
    @Test
    @DisplayName("Try Lock method")
    public void tryLockMethod(
            @CompileClasses(classesToCompile = "TryLockMethod.java", sourcePath = "c18/writing_thread_safe_code")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "TryLockMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The cycling barrier class takes in its constructor a limit value,
     * indicating a number of threads to wait for.
     * As each thread finishes, it calls the await method on the cyclic barrier
     * once the specified numbers of threads have each called await, the barrier
     * is released.
     * It allows us to perform complex, multithreaded tasks and wait at
     * logical barriers.
     */
    @Test
    @DisplayName("Using a cyclic barrier")
    public void usingCyclicBarrier(
            @CompileClasses(classesToCompile = "UsingCyclicBarrier.java", sourcePath = "c18/writing_thread_safe_code")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "UsingCyclicBarrier")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
