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
 * This class contain tests to validate rules about Primitive Streams
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class PrimitiveStreamsTest {

    /**
     * Java actually includes other Stream classes
     * besides {@link java.util.stream.Stream}
     * that you can use to work with primitives
     */
    @Test
    @DisplayName("Creating Primitive Streams")
    public void creatingPrimitiveStreams(
            @CompileClasses(classesToCompile = "CreatingPrimitiveStreams.java", sourcePath = "c15/primitive_streams")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Averaging a stream of primitive can be done
     * with average() method on primitive Stream
     */
    @Test
    @DisplayName("Averaging a stream of values")
    public void averagingStreamPrimitive(
            @CompileClasses(classesToCompile = "AveragingStreamPrimitive.java", sourcePath = "c15/primitive_streams")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "AveragingStreamPrimitive")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * We can also obtain a Stream<T> where T is
     * the wrapper class from a Primitive Stream
     * with the boxed() method
     */
    @Test
    @DisplayName("Creating a non primitive Stream from a primitive Stream")
    public void boxedMethod(
            @CompileClasses(classesToCompile = "BoxedMethod.java", sourcePath = "c15/primitive_streams")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Getting the max from stream of primitive can be done
     * with max() method on primitive Stream
     */
    @Test
    @DisplayName("Getting max from a stream of primitives")
    public void maxMethodPrimitiveStream(
            @CompileClasses(classesToCompile = "MaxMethodPrimitiveStream.java", sourcePath = "c15/primitive_streams")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "MaxMethodPrimitiveStream")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Getting the min from stream of primitive can be done
     * with min() method on primitive Stream
     */
    @Test
    @DisplayName("Getting min from a stream of primitives")
    public void minMethodPrimitiveStream(
            @CompileClasses(classesToCompile = "MinMethodPrimitiveStream.java", sourcePath = "c15/primitive_streams")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "MinMethodPrimitiveStream")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }


    /**
     * Getting the range from a (inclusive) to b (inclusive)
     * as a stream of primitive can be done
     * with range() method on primitive Stream
     */
    @Test
    @DisplayName("Getting range from primitive Stream")
    public void rangeMethod(
            @CompileClasses(classesToCompile = "RangeMethod.java", sourcePath = "c15/primitive_streams")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "RangeMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Getting the range from a (inclusive) to b (inclusive)
     * as a stream of primitive can be done
     * with rangeClosed() method on primitive Stream
     */
    @Test
    @DisplayName("Getting rangeClosed from primitive Stream")
    public void rangeClosedMethod(
            @CompileClasses(classesToCompile = "RangeClosedMethod.java", sourcePath = "c15/primitive_streams")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "RangeClosedMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * There is a method to sum all the numbers in a
     * primitive stream, called sum()
     */
    @Test
    @DisplayName("Sum method in primitive streams")
    public void sumMethodPrimitiveStream(
            @CompileClasses(classesToCompile = "SumMethodPrimitiveStream.java", sourcePath = "c15/primitive_streams")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "SumMethodPrimitiveStream")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * There is a SummaryStatistics Stream
     * that can be used to obtain multiple
     * data from the same streams when they are run
     */
    @Test
    @DisplayName("Statistics Stream")
    public void summaryStatisticsPrimitiveStream(
            @CompileClasses(classesToCompile = "SummaryStatisticsPrimitiveStream.java", sourcePath = "c15/primitive_streams")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }
}
