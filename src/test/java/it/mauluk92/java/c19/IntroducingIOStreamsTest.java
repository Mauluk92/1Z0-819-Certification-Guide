package it.mauluk92.java.c19;

import java.io.*;
import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contain tests to illustrate concepts about I/O streams
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class IntroducingIOStreamsTest {

    /**
     * The contents of a file may be accessed or written via a stream, which
     * is a list of data elements presented sequentially. Streams should be
     * conceptually thought of as a long nearly never-ending "stream of water"
     * with data presented one "wave" at a time.
     * We just have a pointer to our current position in the stream and
     * read data one block at a time
     */
    @Test
    @DisplayName("Introduction to I/O Streams")
    public void introductionIOStreams(){}

    /**
     * The java.io API provides numerous classes for creating, accessing,
     * manipulating streams. We have byte streams which are used to access,
     * generally, images or executables. Char Streams are used to read and write
     * files. We also have InputStream and OutputStream, low level and high level
     * streams. The java.io defines four abstract classes that are the parents of
     * all classes inside the package: {@link InputStream}, {@link OutputStream},
     * {@link Reader}, {@link Writer}.
     */
    @Test
    @DisplayName("Definitions of I/O streams")
    public void streamsBaseClasses(){}
}
