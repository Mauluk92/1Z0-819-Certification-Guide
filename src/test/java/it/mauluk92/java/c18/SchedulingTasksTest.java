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
 * This class contain tests to validate rules about scheduling tasks with Concurrency API
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class SchedulingTasksTest {

    /**
     * Oftentimes in Java, we need to schedule a task to happen
     * at some time in the future. We might need to schedule the task
     * to happen repeatedly, at some set interval.
     */
    @Test
    @DisplayName("Schedule method")
    public void scheduleMethod(
            @CompileClasses(classesToCompile = "ScheduleMethod.java", sourcePath = "c18/scheduling_tasks")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ScheduleMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * scheduleAtFixedRate method creates and executes a Runnable task
     * after the given initial delay, creating a new task every period value
     * that passes
     */
    @Test
    @DisplayName("ScheduleAtFixedRate method")
    public void scheduleAtFixedRateMethod(
            @CompileClasses(classesToCompile = "ScheduleAtFixedRateMethod.java", sourcePath = "c18/scheduling_tasks")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ScheduleAtFixedRateMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * scheduleWithFixedDelay method creates and executes a Runnable task
     * after the given initial delay and subsequently with the given
     * delay between the termination of one execution and the
     * commencement of the next
     */
    @Test
    @DisplayName("ScheduleWithFixedDelay method")
    public void scheduleWithFixedDelay(
            @CompileClasses(classesToCompile = "ScheduleWithFixedDelay.java", sourcePath = "c18/scheduling_tasks")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ScheduleWithFixedDelay")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
