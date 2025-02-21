package it.mauluk92.java.c19;
import java.io.*;
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
 * This class contain tests to validate rules about using {@link File}
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UnderstandingFilesTest {

    /**
     * Data is stored on persistent storage devices, such as hard disk and memory cards.
     * A file is a record within the storage device that holds data. Files are organized
     * into hierarchies using directories. A directory is a location that can
     * contain files as well as other directories. When working with directories in Java, we
     * often treat them like files. In fact, we use many of the same classes to operate
     * on files and directories. To interact with files, we need to connect to the
     * file system. The file system is in charge of reading and writing data within
     * a computer. Different OS use different file systems to manage their data.
     * A root directory is the topmost directory in the file system, from which all files
     * and directories inherit.
     * Finally, a path is a string representation of a file or directory within a file system.
     * Each file system defines its own path separator character that is used between directories
     * entities.
     */
    @Test
    @DisplayName("Conceptualizing file systems")
    public void fileSystems(
            @CompileClasses(classesToCompile = "FileSystems.java", sourcePath = "c19/understanding_files")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * The first class we will discuss ine one of the most commonly used in the
     * java.io API: the {@link File} class. The File class is used to read
     * information about existing files and directories, list the content of a directory,
     * and create, delete files and directories.
     * An instance of a file class represents the path to a particular file or directory
     * on the file system. The file class cannot read or write data within a file, although
     * it can be passed as a reference to many stream classes to read or write data.
     * A file object is initialized with a string containing either an absolute path or relative
     * path.
     */
    @Test
    @DisplayName("Operating on files")
    public void operatingOnFiles(
            @CompileClasses(classesToCompile = "OperatingOnFiles.java", sourcePath = "c19/understanding_files")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "OperatingOnFiles", classPath = "c19/understanding_files/files_test")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
