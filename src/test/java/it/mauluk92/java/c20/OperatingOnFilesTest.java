package it.mauluk92.java.c20;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

/**
 * This class contain tests to validate rules about interacting with Files and Directories
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class OperatingOnFilesTest {

    /**
     * Most of the methods we covered in the {@link Path} interface operate
     * on theoretical paths, which are not required to exist within
     * the file system. The {@link Files} helper class is capable
     * of interacting within the file system. Because of this, most of the
     * methods takes optional parameters and throw {@link java.io.IOException}
     * if the path does not exist.
     * The following method, though, does not throw any Exception while checking
     * if the file/folder exists: it simply returns false
     */
    @Test
    @DisplayName("Checking file existence")
    public void checkingFileExistence(
            @TempDir Path tempDir
    ){
        Path nonExistentPath = Path.of("non", "existent", "path");

        Assertions.assertTrue(Files.exists(tempDir));
        Assertions.assertFalse(Files.exists(nonExistentPath));
    }

    /**
     * Since a path may include path symbols and symbolic links within a
     * file system, it can be difficult to know if two Path instances refer to the
     * same file. The method we are going to cover takes two Path objects as input, resolves
     * all path symbols, and follows symbolic links. Can also be used to determine if
     * two Path objects refer to the same directory. Will trigger
     * an {@link java.io.IOException} if path does not exist.
     */
    @Test
    @DisplayName("Checking sameness of files")
    public void checkingSameness(
            @TempDir Path tempDir
    ) throws IOException {
        Path equivalentPath = tempDir.getParent().resolve(tempDir.getFileName());
        Path nonEquivalentNonExistentPath = Path.of("non", "equivalent", "path");
        Path nonEquivalentPath = Path.of(".");

        Assertions.assertTrue(Files.isSameFile(tempDir, equivalentPath));
        Assertions.assertFalse(Files.isSameFile(tempDir, nonEquivalentPath));
        Assertions.assertThrows(IOException.class, () -> Files.isSameFile(tempDir, nonEquivalentNonExistentPath));
    }

    /**
     * To create a directory, we use these {@link Files} methods:
     * The createDirectory() will create a directory and throw an exception if it already
     * exists or the paths leading up to the directory do not exist.
     * The createDirectories() creates the target directory along with any nonexistent
     * parent directories leading up to the path. If all directories already exist,
     * createDirectories() will simply complete without doing anything. This is
     * useful in situations where you want to ensure a directory exists and create it
     * if it doesn't. Both accept an optional list of {@link java.nio.file.attribute.FileAttribute}
     * values to apply to the newly created directory or directories.
     */
    @Test
    @DisplayName("Creating directories")
    public void creatingDirectories(
            @TempDir Path tempDir
    ){
        Path subFolder = tempDir.resolve("subFolder");
        Path nestedSubFolder = subFolder.resolve("nexted");

        Assertions.assertDoesNotThrow(() -> Files.createDirectory(subFolder)); // Creating the subfolder
        Assertions.assertThrows(IOException.class, () -> Files.createDirectory(subFolder)); // The folder already exists and an Exception is thrown

        Assertions.assertDoesNotThrow(() -> Files.createDirectories(nestedSubFolder));
        Assertions.assertDoesNotThrow(() -> Files.createDirectories(nestedSubFolder)); // Will not throw an exception!
    }

    /**
     * The NIO.2 {@link Files} class provides a method for copying files and directories
     * within the file system. The method copies a file or directory from one location
     * to another using Path objects. The following shows an example of copying a file
     * and a directory. When directories are copied, the copy is shallow.
     * A <em>shallow copy</em> means that the files and subdirectories within the directory
     * are not copied. A deep <em>deep copy</em> means that the entire tree is copied, including
     * all of its content and subdirectories. By default, if the target already exists, the
     * copy() method will throw an exception. You can change this behavior by providing the
     * {@link java.nio.file.StandardCopyOption} enum value REPLACE_EXISTING to the method.
     */
    @Test
    @DisplayName("Creating a shallow copy")
    public void creatingShallowCopy(
            @TempDir Path tempDir
    ) throws IOException {
        Path copyDirectory = tempDir.resolve("copy_directory");
        Path target = copyDirectory.resolve("directory");
        Path directory = tempDir.resolve("directory");
        Path subDirectory = directory.resolve("subdirectory");

        Path hypotheticalNestedDirectory = target.resolve("subdirectory");

        // Creating directories

        Files.createDirectories(subDirectory);
        Files.createDirectories(copyDirectory);

        // Making a shallow copy of directory which contains another directory
        Assertions.assertDoesNotThrow(() -> Files.copy(directory, target));
        Assertions.assertTrue(Files.exists(target)); // True
        Assertions.assertFalse(Files.exists(hypotheticalNestedDirectory)); // False, because it is a shallow copy

        Assertions.assertThrows(IOException.class, () -> Files.copy(directory, target)); // True because default behavior is not to overwrite existing files!
        Assertions.assertDoesNotThrow(() -> Files.copy(directory, target, StandardCopyOption.REPLACE_EXISTING)); // Will not throw any exception, but will overwrite any existing file
    }

    /**
     * {@link Files} class provides two copy() methods that operate with I/O streams.
     * The first method reads the contents of a stream and writes the output to a file.
     * The second method reads the contents of a file and writes the output to a stream.
     * They are quite convenient if you need to quickly read/write data from/to disk.
     */
    @Test
    @DisplayName("Creating a copy from/to I/O streams")
    public void copyFromStreams(
            @TempDir Path tempDir
    ) throws IOException {
        Path directory = tempDir.resolve("directory");
        Path subDirectory = directory.resolve("subdirectory");
        Path pathToTextualFile = subDirectory.resolve("hello.txt");

        // Creating directories

        Files.createDirectories(subDirectory);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Hello World!".getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        Files.copy(byteArrayInputStream, pathToTextualFile);
        Files.copy(pathToTextualFile, byteArrayOutputStream);

        Assertions.assertTrue(Files.exists(pathToTextualFile)); // File created
        Assertions.assertEquals("Hello World!", byteArrayOutputStream.toString()); // Output valid

    }

    /**
     * {@link Files} class provides a useful method for moving or
     * renaming files and directories. Move requires REPLACING_EXISTING
     * to overwrite the target if it exists already, else it throws
     * an exception. Also like copy(), move() will not put a file
     * into a directory. Also, we can use an atomic move with
     * ATOMIC_MOVE as a single indivisible operation. Put another way, any
     * process monitoring the file system never sees an incomplete o partially
     * written file
     */
    @Test
    @DisplayName("Renaming or moving a file")
    public void renamingOrMovingAFile(
            @TempDir Path tempDir
    ) throws IOException {
        Path directory = tempDir.resolve("directory");
        Path subDirectory = directory.resolve("subdirectory");
        Path pathToTextualFile = subDirectory.resolve("hello.txt");
        Path pathOther = subDirectory.resolve("other.txt");

        Path targetMove = directory.resolve("target.txt");

        // Creating directories

        Files.createDirectories(subDirectory);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Hello World!".getBytes());

        // Writing to file

        Files.copy(byteArrayInputStream, pathToTextualFile);

        Assertions.assertFalse(Files.exists(targetMove)); // Before moving, it doesn't exist
        Assertions.assertDoesNotThrow(() -> Files.move(pathToTextualFile, targetMove)); // Moving file
        Assertions.assertTrue(Files.exists(targetMove)); // After moving file check
        Assertions.assertThrows(IOException.class, () -> Files.move(pathOther, pathToTextualFile));
        Assertions.assertDoesNotThrow(() -> Files.move(targetMove, pathToTextualFile, StandardCopyOption.REPLACE_EXISTING));
    }

    /**
     * {@link Files} class includes two methods that delete a file
     * or empty directory within the file system.
     * To delete a directory, it must be empty. Both of these two methods
     * throw an exception if operated on non-empty directory.
     * In addition, if the path is a symbolic link, then the symbolic link will be
     * deleted, not the path that symbolic link point to.
     * To delete() method throws an exception if the path does not exist,
     * while deleteIfExists() method return true if deletion was successful,
     * false otherwise
     */
    @Test
    @DisplayName("Deleting a file")
    public void deletingAFile(
            @TempDir Path tempDir
    ) throws IOException {
        Path directory = tempDir.resolve("directory");
        Path subDirectory = directory.resolve("subdirectory");

        Files.createDirectories(subDirectory);

        Assertions.assertThrows(IOException.class, () -> Files.delete(directory)); // Will throw an exception since directory is not empty
        Assertions.assertThrows(IOException.class, () -> Files.deleteIfExists(directory)); // Same behaviour

        Assertions.assertDoesNotThrow(() -> Files.delete(subDirectory));
        Assertions.assertThrows(IOException.class, () -> Files.delete(subDirectory)); // Attempting to delete nonexistent file will raise exception

        Assertions.assertDoesNotThrow(() -> Files.deleteIfExists(subDirectory)); // Method deleteIfExists() will not raise exception
        Assertions.assertFalse(Files.deleteIfExists(subDirectory)); // But will return false if deletion was impossible
    }

    /**
     * NIO.2 includes two convenient methods for working with I/O streams.
     * The first method, reads the file specified at the Path location using a
     * {@link java.io.BufferedReader}. The second method writes to a file specified
     * at the Path location using a {@link java.io.BufferedWriter}
     */
    @Test
    @DisplayName("Reading and writing using Files class")
    public void readingWritingFiles(
            @TempDir Path tempDir
    ) throws IOException {
        Path directory = tempDir.resolve("directory");
        Path subDirectory = directory.resolve("subdirectory");
        Path file = subDirectory.resolve("file.txt");
        Path otherFile = subDirectory.resolve("other.txt");

        // Creating directories and files

        Files.createDirectories(subDirectory);
        Files.createFile(otherFile);


        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Hello World!".getBytes());

        // Writing to file

        Files.copy(byteArrayInputStream, file);

        try(BufferedReader bufferedReader = Files.newBufferedReader(file);
            BufferedWriter bufferedWriter = Files.newBufferedWriter(otherFile)){
            Assertions.assertEquals("Hello World!", bufferedReader.readLine());
            Assertions.assertDoesNotThrow(() -> {
                bufferedWriter.append("Hello World!");
            });
        }
    }

    /**
     * The {@link Files} class includes a convenient method for turning the lines
     * of a file into a List. Be aware that the entire file is read when readAllLines()
     * is called, with the resulting List storing all the contents of the file
     * in memory at once. If the file is significantly large, then you may trigger
     * an {@link OutOfMemoryError} trying to load all of it into memory.
     */
    @Test
    @DisplayName("Reading all lines at once")
    public void readAllLinesMethod(
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

        // Getting all lines!

        List<String> lines = Files.readAllLines(file);

        Assertions.assertEquals(2, lines.size());
        Assertions.assertEquals("Hello World!", lines.get(0));
        Assertions.assertEquals("Second Line!", lines.get(1));
    }
}
