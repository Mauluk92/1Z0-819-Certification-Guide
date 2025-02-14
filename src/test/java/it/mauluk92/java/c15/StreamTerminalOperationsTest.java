package it.mauluk92.java.c15;

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
 * This class contain tests to validate rules about creating Streams
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class StreamTerminalOperationsTest {

    /**
     * The count() method determines the number of elements
     * in a finite Stream. For an infinite stream, it never
     * terminates. Returns a long value
     */
    @Test
    @DisplayName("Applying count to Stream")
    public void countMethod(
            @CompileClasses(classesToCompile = "CountMethod.java", sourcePath = "c15/stream_terminal_operations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CountMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The min() and max() methods allows to pass a custom comparator
     * and find the smallest or largest value in a finite Stream
     * according to that sort order. Like the count, min, max, hang on
     * an infinite Stream.
     */
    @Test
    @DisplayName("Applying min or max to Stream")
    public void minMaxMethods(
            @CompileClasses(classesToCompile = "MinMaxMethods.java", sourcePath = "c15/stream_terminal_operations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "MinMaxMethods")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The findAny() and findFirst() methods
     * return an element of the stream unless the Stream
     * is empty: in such a case it will return an empty optional
     */
    @Test
    @DisplayName("Applying findAny and findFirst")
    public void findMethods(
            @CompileClasses(classesToCompile = "FindMethods.java", sourcePath = "c15/stream_terminal_operations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "FindMethods")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * These methods search a stream and returns information
     * about how the stream pertains to the predicate.
     * These may or may not terminate an infinite Stream. It depends
     * on data.
     */
    @Test
    @DisplayName("Match Stream methods")
    public void matchMethods(
            @CompileClasses(classesToCompile = "MatchMethods.java", sourcePath = "c15/stream_terminal_operations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "MatchMethods")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Like in Java Collection framework, it is common to iterate over the elements
     * on a stream. As expected, calling forEach() on an infinite Stream does
     * not terminate. Since there is no return value, it is not a reduction
     */
    @Test
    @DisplayName("ForEach Stream method")
    public void forEachMethod(
            @CompileClasses(classesToCompile = "ForEachMethod.java", sourcePath = "c15/stream_terminal_operations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ForEachMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The reduce method combines a stream into a single object. It is a reduction
     * which means it processes all elements in a stream.
     * There are three overloaded methods for reduce.
     */
    @Test
    @DisplayName("Reduce Stream methods")
    public void reduceStreamMethods(
            @CompileClasses(classesToCompile = "ReduceStreamMethods.java", sourcePath = "c15/stream_terminal_operations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ReduceStreamMethods")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The collect() method is a special type of reduction called
     * a mutable reduction. It is more efficient than a regular
     * reduction because we use the same mutable object while accumulating.
     * Common mutable objects include StringBuilder and
     * ArrayList. This is really useful, because it lets us get data
     * out of Streams and into another form.
     */
    @Test
    @DisplayName("Collect Stream method")
    public void collectStreamMethod(
            @CompileClasses(classesToCompile = "CollectStreamMethod.java", sourcePath = "c15/stream_terminal_operations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CollectStreamMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
