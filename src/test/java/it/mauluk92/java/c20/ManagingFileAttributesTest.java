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
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

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

    /**
     * The {@link Files} class includes a method to determine
     * the size of file in bytes. The size returns by this method
     * references the conceptual size of data, and this may differ
     * from the actual size on the persistent storage.
     */
    @Test
    @DisplayName("Checking file size")
    public void checkFileSize(
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

        System.out.println("File size is: " + Files.size(file));
        Assertions.assertTrue(Files.size(file) > 0);
    }

    /**
     * Most operating systems support a last modified date/time
     * value with each file. Some applications use this to determine
     * when the files' contents should be read again. In the majority
     * of circumstances, it is a lot faster to check a single metadata attribute
     * than to record the entire contents of file.
     */
    @Test
    @DisplayName("Checking file last modified timestamp")
    public void checkLastModified(
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

        System.out.println("File last modified time : " + Files.getLastModifiedTime(file).toInstant());
        Assertions.assertTrue(Files.getLastModifiedTime(file).toMillis() > 0L);
    }

    /**
     * Put simply, it is far more efficient to ask the file system for
     * all attributes at once rather than performing multiple
     * round-trips to the file system.
     * NIO.2 addresses both of these concern by allowing you
     * to construct views for various file systems with a
     * single method call. A view is a group of related attributes
     * for a particular file system type.
     * NIO.2 includes two methods for working with attributes:
     * a read-only attributes method and updatable view method
     */
    @Test
    @DisplayName("Obtaining Basic File Attributes")
    public void obtainingBasicFileAttributes(
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

        Assertions.assertInstanceOf(BasicFileAttributes.class, Files.readAttributes(file, BasicFileAttributes.class));
        Assertions.assertInstanceOf(BasicFileAttributeView.class, Files.getFileAttributeView(file, BasicFileAttributeView.class));
    }
}
