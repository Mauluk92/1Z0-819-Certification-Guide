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
public class StreamIntermediateOperationsTest {

    /**
     * Stream filter() method returns a stream that
     * match a given expression in a Predicate
     */
    @Test
    @DisplayName("Filter Stream method")
    public void filteringStreams(
            @CompileClasses(classesToCompile = "FilteringStreams.java", sourcePath = "c15/stream_intermediate_operations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "FilteringStreams")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The distinct() method returns a stream with
     * duplicate values removed. The duplicates do not need to be
     * adjacent to be removed
     */
    @Test
    @DisplayName("Dictinct Stream Method")
    public void distinctMethod(
            @CompileClasses(classesToCompile = "DistinctMethod.java", sourcePath = "c15/stream_intermediate_operations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "DistinctMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * These methods can make a Stream smaller or
     * they can make a finite Stream out of an
     * infinite Stream
     */
    @Test
    @DisplayName("Limit and skip methods")
    public void limitSkipMethods(
            @CompileClasses(classesToCompile = "LimitSkipMethods.java", sourcePath = "c15/stream_intermediate_operations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "LimitSkipMethods")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The map() method creates a one to one mapping
     * from the elements in the stream to the elements of the next step
     * in the stream
     */
    @Test
    @DisplayName("Map Stream method")
    public void mapMethod(
            @CompileClasses(classesToCompile = "MapMethod.java", sourcePath = "c15/stream_intermediate_operations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "MapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The flatMap() method takes each element
     * in the stream and makes any elements it contains
     * top-level elements in a single Stream. Useful
     * for streams of lists.
     */
    @Test
    @DisplayName("FlatMap Stream method")
    public void flatMapMethod(
            @CompileClasses(classesToCompile = "FlatMapMethod.java", sourcePath = "c15/stream_intermediate_operations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "FlatMapMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The sorted() method returns a stream
     * with elements sorted either in natural order
     * or by providing a comparator (custom or not)
     */
    @Test
    @DisplayName("Sorted Stream method")
    public void sortedMethod(
            @CompileClasses(classesToCompile = "SortedMethod.java", sourcePath = "c15/stream_intermediate_operations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "SortedMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The peek() method is useful for debugging
     * because it allows to perform
     * a stream operation without changing the stream
     */
    @Test
    @DisplayName("Peek Stream Method")
    public void peekMethod(
            @CompileClasses(classesToCompile = "PeekMethod.java", sourcePath = "c15/stream_intermediate_operations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "PeekMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
