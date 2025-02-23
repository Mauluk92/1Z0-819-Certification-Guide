package it.mauluk92.java.c20;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.*;

/**
 * This class contain tests to validate rules about managing file attributes
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class ManagingFileAttributesTest {

    /**
     * The {@link Files} class includes three methods for determining
     * the type of path. The isDirectory() and isSymbolicLink() methods
     * should be self-explanatory. Java defines a regular file
     * as one that can contain content, as opposed to a symbolic link,
     * directory, resource, or other non-regular file that may be
     * present in some operating system. If the symbolic link
     * points to an actual file, Java will perform the check on
     * target of symbolic link
     */
    @Test
    @DisplayName("Type of path")
    public void typeOfPath(
            @TempDir Path tempDir
    ) throws IOException {
        Path directory = tempDir.resolve("directory");
        Path subDirectory = directory.resolve("subdirectory");
        Path file = subDirectory.resolve("file.txt");

        // Creating directories and files

        Files.createDirectories(subDirectory);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Hello World!\nSecond Line!".getBytes());

        // Writing to file

        Files.copy(byteArrayInputStream, file);

        Assertions.assertTrue(Files.isRegularFile(file));
        Assertions.assertFalse(Files.isDirectory(file));
        Assertions.assertFalse(Files.isSymbolicLink(file));
    }

    /**
     * In many operating systems, it is possible to set a boolean attribute
     * to a file that marks it hidden, readable, or executable. The
     * {@link Files} include methods that exposes this information.
     */
    @Test
    @DisplayName("Checking file accessibility")
    public void fileAccessibility(
            @TempDir Path tempDir
    ) throws IOException {
        Path directory = tempDir.resolve("directory");
        Path subDirectory = directory.resolve("subdirectory");
        Path file = subDirectory.resolve("file.txt");

        // Creating directories and files

        Files.createDirectories(subDirectory);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Hello World!\nSecond Line!".getBytes());

        // Writing to file

        Files.copy(byteArrayInputStream, file);


        Assertions.assertTrue(Files.isReadable(file));
        Assertions.assertTrue(Files.isWritable(file));
        Assertions.assertFalse(Files.isHidden(file));
        Assertions.assertTrue(Files.isExecutable(file));
    }
}
