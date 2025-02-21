package it.mauluk92.java.c19;

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
 * This class contain tests to validate rules about using I/O Streams
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class CommonIOStreamOperationsTest {


    /**
     * I/O streams are all about reading and writing data, so it shouldn't
     * be a surprise that the most important methods are read() and write().
     */
    @Test
    @DisplayName("ReadingWritingStreams")
    public void readingWritingStreams(
            @CompileClasses(classesToCompile = "ReadingWritingStreams.java", sourcePath = "c19/common_io_stream_operations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ReadingWritingStreams")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The mark() and reset() methods return a stream to an earlier position.
     * Before calling either of these methods, you should call the markSupported() method,
     * which returns true only if mark() is supported for the given stream!
     * The skip() method is pretty simple; it basically reads data from
     * the stream and discards the contents
     */
    @Test
    @DisplayName("Other utility methods from I/O Streams")
    public void otherMethods(
            @CompileClasses(classesToCompile = "OtherMethods.java", sourcePath = "c19/common_io_stream_operations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "OtherMethods")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * When data is written to an output stream, the underlying operating system
     * does not guarantee that the data will make it to the file system immediately.
     * In many operating systems, the data may be cached in memory, with a write operation
     * occurring only after a temporary cache is filled or after some amount of time has passed.
     * If the data is cached in memory and the application terminates unexpectedly, the data
     * would be lost, because it was never written to the file system.
     * All output streams classes provide a flush method, which requires
     * that all accumulated data be written immediately to disk.
     * The flush() method helps reduce the amount of data lost if the application terminates
     * unexpectedly. It may cause a delay in application, especially for large files. Shouldn't be
     * used after every write.
     */
    @Test
    @DisplayName("Flush method")
    public void flushMethod(
            @CompileClasses(classesToCompile = "FlushMethod.java", sourcePath = "c19/common_io_stream_operations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "FlushMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
