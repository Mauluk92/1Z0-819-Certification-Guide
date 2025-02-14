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
public class CreatingStreamSourcesTest {

    /**
     * Stream.empty() creates a new, finite, empty stream
     */
    @Test
    @DisplayName("Creating an empty Stream")
    public void creatingAnEmptyStream(
            @CompileClasses(classesToCompile = "CreatingAnEmptyStream.java", sourcePath = "c15/creating_stream_sources")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CreatingAnEmptyStream")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Stream.of(varargs) creates a new, finite, stream
     * with as many elements as the varargs argument
     */
    @Test
    @DisplayName("Creating a vararg Stream")
    public void creatingAVarargStream(
            @CompileClasses(classesToCompile = "CreatingAVarargStream.java", sourcePath = "c15/creating_stream_sources")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CreatingAVarargStream")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * stream() method from Collection interface can be used to
     * create a new, finite, stream
     * with as many elements as the collection itself
     */
    @Test
    @DisplayName("Creating a stream from Collection")
    public void streamFromCollection(
            @CompileClasses(classesToCompile = "StreamFromCollection.java", sourcePath = "c15/creating_stream_sources")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "StreamFromCollection")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Stream method iterate can be used to create new
     * infinite stream from a seed with an operation applied
     * to it. A predicate can be used optionally to
     * terminate che infinite stream
     */
    @Test
    @DisplayName("Creating a stream from iteration")
    public void streamIteration(
            @CompileClasses(classesToCompile = "StreamIteration.java", sourcePath = "c15/creating_stream_sources")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "StreamIteration")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }


    /**
     * Stream method generate can be used to create new
     * infinite stream from continuous application of
     * a supplier.
     */
    @Test
    @DisplayName("Creating a stream through generate")
    public void streamGenerate(
            @CompileClasses(classesToCompile = "StreamGenerate.java", sourcePath = "c15/creating_stream_sources")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "StreamGenerate")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
