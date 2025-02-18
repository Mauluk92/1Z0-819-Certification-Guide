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
 * This class contain tests to validate rules about using {@link java.util.concurrent.ExecutorService}
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class IntroducingConcurrencyAPITest {

    /**
     * Java includes the Concurrency API to handle the complicated
     * work of managing threads for you. The concurrency API includes
     * the {@link java.util.concurrent.ExecutorService} interface, which
     * defines services that create and manage threads for you.
     * You first obtain an instance of an Executor interface, and then
     * you send the service tasks to be processed.
     * The <b>framework</b> includes numerous useful features, such as
     * thread pooling and scheduling. It is recommended that you use this framework
     * anytime you need to create and execute a separate task, even if you need only a single
     * thread. Since ExecutorService is an interface, how do you obtain an instance of it?
     * The concurrency API includes the {@link java.util.concurrent.Executors}
     * factory class that can be used to create appropriate instances such as the
     * <b>single thread executor</b>
     */
    @Test
    @DisplayName("Single thread executor")
    public void singleThreadExecutor(
            @CompileClasses(classesToCompile = "SingleThreadExecutor.java", sourcePath = "c18/introducing_concurrency_api")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "SingleThreadExecutor")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Once you have finished using a Thread executor, it
     * is important that you call the shutdown (method a thread
     * executor creates a non daemon thread on the first
     * task that is executed, so falling to call shutdown
     * will result in your application never terminating.
     * The shutdown process for a thread executor
     * involves first rejecting any new tasks submitted to the thread
     * while continuing to execute any previously submitted tasks.
     * During this time, calling isShutdown() will return true, while
     * isTerminated() will return false. If a new task is submitted
     * to the thread executor while it is shutting down,
     * a RejectedExecutionException will be thrown.
     */
    @Test
    @DisplayName("Shutting down a thread executor")
    public void shuttingDownThreadExecutor(
            @CompileClasses(classesToCompile = "ShuttingDownThreadExecutor.java", sourcePath = "c18/introducing_concurrency_api")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ShuttingDownThreadExecutor")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * You can submit tasks to an executor service instance
     * multiple ways. The first method, execute(), is inherited
     * from {@link java.util.concurrent.Executor}, which the
     * executor interface extends the execute() method
     * takes a {@link Runnable} lambda expression or instance
     * and completes the task asynchronously. Because the
     * return type of method is void, it does not tell
     * us anything about the result of the task. It is
     * considered <em>fire and forget</em>, as one it is
     * submitted, the results are not directly available
     * to the calling thread. Fortunately, a submit method returns
     * a Future instance that can be used to determine
     * whether the task is complete. It can also be used
     * to return a generic result object after the task has been
     * completed.
     */
    @Test
    @DisplayName("Submitting tasks")
    public void submittingTask(
            @CompileClasses(classesToCompile = "SubmittingTask.java", sourcePath = "c18/introducing_concurrency_api")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "SubmittingTask")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
