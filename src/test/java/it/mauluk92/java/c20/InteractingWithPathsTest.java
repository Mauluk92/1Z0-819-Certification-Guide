package it.mauluk92.java.c20;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.util.Assert;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class contain tests to validate rules about interacting with {@link Path} instances
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class InteractingWithPathsTest {

    /**
     * The first method, toString(), returns a String representation
     * of the entire path. In fact, it's the only method in the {@link Path}
     * interface to return a string. Many of the other methods in the Path
     * interface return Path instances.
     * The getNameCount() and getName() methods are often used in conjunction
     * to retrieve the number of elements in the path and a references to each
     * element, respectively. These two methods do not include the root directory
     * as part of the path.
     */
    @Test
    @DisplayName("Viewing paths")
    public void viewingPaths(){
        String fileName = "file.txt";
        Path relativePath = Paths.get("relative\\path", fileName);

        Assertions.assertEquals("relative\\path\\file.txt", relativePath.toString());
        Assertions.assertEquals(3, relativePath.getNameCount());
        Assertions.assertEquals(Path.of(fileName), relativePath.getName(relativePath.getNameCount() -1));
    }

    /**
     * The {@link Path} interface includes a method to select portions of the path.
     * The references are inclusive of the start index and exclusive of the end index.
     * Returns multiple paths elements.
     */
    @Test
    @DisplayName("Selecting subPath")
    public void subPathMethod(){
        String fileName = "file.txt";
        Path relativePath = Paths.get("relative\\path", fileName);

        Path subPath = relativePath.subpath(relativePath.getNameCount() - 2, relativePath.getNameCount());

        Assertions.assertEquals(Path.of("path\\file.txt"), subPath);
    }

    /**
     * The {@link Path} interface contains numerous methods for
     * retrieving particular elements of a path, returned as
     * Path objects themselves.
     */
    @Test
    @DisplayName("Accessing path elements")
    public void accessingPathElements(){
        String fileName = "file.txt";
        Path relativePath = Paths.get("relative\\path", fileName);

        Path fileNamePathElement = relativePath.getFileName();
        Path parentPath = relativePath.getParent();
        Path rootElement = relativePath.getRoot(); // Will be null since we are working with relative paths


        Assertions.assertEquals(Path.of(fileName), fileNamePathElement);
        Assertions.assertEquals(Path.of("relative\\path"), parentPath);
        Assertions.assertNull(rootElement);
    }

    /**
     * The {@link Path} interface contains two methods for assessing
     * relative and absolute paths. These methods are toAbsolutePath()
     * returns the Path joining it with the Path of the current work
     * directory, while isAbsolute() returns true only if the path is not relative.
     */
    @Test
    @DisplayName("Assessing absolute path")
    public void assessingAbsolutePath(){
        String fileName = "file.txt";
        Path relativePath = Paths.get("relative\\path", fileName);

        Path absolutePath = relativePath.toAbsolutePath();

        Assertions.assertTrue(absolutePath.isAbsolute()); // Will be true
        Assertions.assertFalse(relativePath.isAbsolute()); // Will be false
    }

    /**
     * The {@link Path} interface contains a method to concatenate
     * multiple paths and this is the resolve() method which takes
     * as its basis for the new path, the current instance, while
     * joining the other path passed as argument to the method
     */
    @Test
    @DisplayName("Resolving paths")
    public void resolvingPaths(){
        String fileName = "file.txt";
        String basePath = "relative\\path";

        Path fullPath = Paths.get(basePath, fileName);
        Path resolvedPath = Path.of(basePath).resolve(Path.of(fileName));

        Assertions.assertEquals(fullPath, resolvedPath); // These paths will be the same!
    }

    /**
     * The {@link Path} interface contains a method for constructing
     * the relative path from one Path to another, using path symbols.
     * The idea is this: if you are pointed at a path in the file system,
     * what steps would uou need to take to reach the other path? If both
     * paths are relative, then the relativize() method computes the paths as if they are
     * in the same current working directory. Alternatively, if boh path are
     * absolute, then the method computes the relative path from one absolute
     * location to another, regardless of the current working directory.
     * If the types are mixed, one relative and one absolute, an {@link IllegalStateException}
     * is being thrown.
     */
    @Test
    @DisplayName("Relativizing paths")
    public void relativizingPaths(){
        Path path = Paths.get("relative\\path\\file.txt");
        Path otherPath = Paths.get("relative\\another_file.txt");

        Path absoluteOtherPath = Paths.get("c:\\absolute\\");
        // If we are in relative\path\file.txt, this means we have to go up by a directory to reach another_file.txt
        // The resulting path from relative\path\file.txt will be ..\..\another_file.txt

        Path relativePath = Path.of("..", "..", "another_file.txt");


        Assertions.assertEquals(relativePath, path.relativize(otherPath)); // These paths will be the same!
        Assertions.assertThrows(IllegalArgumentException.class, () -> absoluteOtherPath.relativize(path)); // Cannot mix relative and absolute paths!
    }

    /**
     * The {@link Path} interface contains a method to remove
     * redundancies in paths, containing path symbols unnecessary
     * in resolving a path, which can be used to compare
     * to paths object in order to determine if they are, actually
     * the same path!
     */
    @Test
    @DisplayName("Normalizing paths")
    public void normalizingPaths(){
        String redundantPath = ".\\path\\..\\file.txt";
        String actualPath = "file.txt";

        Path redundantPathObject = Path.of(redundantPath);
        Path actualPathObject = Path.of(actualPath);

        Assertions.assertNotEquals(redundantPathObject, actualPathObject); // Will not be the same
        Assertions.assertEquals(redundantPathObject.normalize(), actualPathObject); // ... But upon normalization they turned out to be the same
    }

    /**
     * The {@link Path} interface contains a method to verify
     * if the actual path exists in the file system.
     * It eliminates redundancy like normalize() and it will generate
     * an absolute Path if is relative. Will throw an exception if the
     * path does not exist!
     */
    @Test
    @DisplayName("Checking if path is real")
    public void toRealPathMethod(){
        String nonExistingPath = "\\non\\existing\\path\\";
        Path nonExistingObjectPath = Path.of(nonExistingPath);
        Path currentWorkingDirectory = Path.of(".");

        Assertions.assertDoesNotThrow(() -> currentWorkingDirectory.toRealPath());
        Assertions.assertThrows(IOException.class, nonExistingObjectPath::toRealPath);

    }
}
