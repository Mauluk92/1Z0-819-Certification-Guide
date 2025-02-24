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
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * This class contain tests to validate rules about using functional programming with NIO.2
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class ApplyingFunctionalProgrammingTest {

    /**
     * The {@link Files} class includes some incredibly useful Stream PI methods
     * that operate on files, directories, and directories trees.
     * Let's start with a simple Stream API method. The following
     * Files method lists the contents of a directory.
     * The Files.list() is similar to the {@link java.io.File} method
     * except it returns a Stream of Path rather than an array.
     * Since streams use lazy evaluation, this means that the method
     * will load each path elements as needed, rather than the entire
     * directory at once.
     */
    @Test
    @DisplayName("Listing files")
    public void listingFiles(
            @TempDir Path tempDir
    ) throws IOException {
        Path directory = tempDir.resolve("directory");
        Path subDirectory = directory.resolve("subdirectory");
        Path secondSubDirectory = directory.resolve("second_subdirectory");
        Path file = subDirectory.resolve("file.txt");

        // Creating directories and files

        Files.createDirectories(subDirectory);
        Files.createDirectories(secondSubDirectory);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Hello World!\nSecond Line!".getBytes());

        // Writing to file

        Files.copy(byteArrayInputStream, file);

        // Listing and counting directories

        try(Stream<Path> listOfFiles = Files.list(directory)){
            Assertions.assertEquals(2L, listOfFiles.count()); // Expected directory count
        }
    }

    /**
     * While the list of method of {@link Files} is useful, it traverses the contents
     * of only a single directory. What if we want to visit all the
     * paths within a directory tree? Every record in a file system has
     * exactly one parent, except for the root directory, which is atop
     * of everything.
     * A file system is commonly visualized as a tree with a single
     * root node and many branches and leaves. A common task is a file system, is to
     * iterate over the descendants of a path, either recording information
     * about them or, more commonly, filtering them for a specific
     * set of files. Generally speaking, if you want to search a file, you
     * have to start with a parent directory. It's child elements, then read their children.
     * Traversing a directory, also referred to as <em>walking the directory tree</em>,
     * is the process by which you start with parent directory and iterate over
     * all its descendants until some condition is met or there are no more
     * elements left.
     */
    @Test
    @DisplayName("Traversing a directory tree")
    public void traversingDirectoryTree(){}

    /**
     * The {@link Files} class includes two methods for walking
     * the directory tree using a depth-first search.
     * Like out other stream methods, walk() uses lazy evaluation
     * and evaluates a Path only as it gets to it. This means that even
     * hundreds or thousands of files, the memory required to process a directory
     * is low. The first walk() method relies on a default maximum depth
     * of Integer.MAX_VALUE, while overloaded version allows the user to set a maximum
     * depth.
     */
    @Test
    @DisplayName("Walking directory tree")
    public void walkingDirectoryTree(
            @TempDir Path tempDir
    ) throws IOException {
        Path directory = tempDir.resolve("directory");
        Path subDirectory = directory.resolve("subdirectory");
        Path secondSubDirectory = directory.resolve("second_subdirectory");
        Path file = subDirectory.resolve("file.txt");

        // Creating directories and files

        Files.createDirectories(subDirectory);
        Files.createDirectories(secondSubDirectory);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Hello World!\nSecond Line!".getBytes());

        // Writing to file

        Files.copy(byteArrayInputStream, file);

        // Searching for all directories (even nested!)

        try(Stream<Path> paths = Files.walk(tempDir)){
            Long numberOfDirectories = paths.filter(Files::isDirectory)
                    .count();
            Assertions.assertEquals(4L, numberOfDirectories); // There are a total of four nested directories!
        }
    }

    /**
     * The {@link Files} class includes a very similar method to walk: find().
     * It takes a {@link java.util.function.BiPredicate} to filter data.
     * It also requires a depth limit to be set. The two parameters of the
     * BiPredicate are a Path object and a BasicFileAttribute object.
     */
    @Test
    @DisplayName("Using find method")
    public void usingFindMethod(
            @TempDir Path tempDir
    ) throws IOException {
        Path directory = tempDir.resolve("directory");
        Path subDirectory = directory.resolve("subdirectory");
        Path secondSubDirectory = directory.resolve("second_subdirectory");
        Path file = subDirectory.resolve("file.txt");

        // Creating directories and files

        Files.createDirectories(subDirectory);
        Files.createDirectories(secondSubDirectory);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Hello World!\nSecond Line!".getBytes());

        // Writing to file

        Files.copy(byteArrayInputStream, file);

        // Searching for all directories (even nested!)

        try(Stream<Path> paths = Files.find(tempDir, 4, (p, b) -> b.isRegularFile())){
            Long numberOfDirectories = paths
                    .count();
            Assertions.assertEquals(1L, numberOfDirectories); // There is only one regular file inside the path!
        }
    }

    /**
     * The {@link Files} class includes a lines() method which is basically
     * the lazy evaluated version of read-all lines method of the same class.
     * This means that only a small portion of the file is stored in memory at any given time.
     */
    @Test
    @DisplayName("Using lines method")
    public void usingLinesMethod(
            @TempDir Path tempDir
    ) throws IOException {
        Path directory = tempDir.resolve("directory");
        Path subDirectory = directory.resolve("subdirectory");
        Path secondSubDirectory = directory.resolve("second_subdirectory");
        Path file = subDirectory.resolve("file.txt");

        // Creating directories and files

        Files.createDirectories(subDirectory);
        Files.createDirectories(secondSubDirectory);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Hello World!\nSecond Line!".getBytes());

        // Writing to file

        Files.copy(byteArrayInputStream, file);

        // Searching for all directories (even nested!)

        try(Stream<String> paths = Files.lines(file)){
            Long numberOfLines = paths
                    .count();
            Assertions.assertEquals(2L, numberOfLines); // Only two lines in textual file
        }
    }
}
