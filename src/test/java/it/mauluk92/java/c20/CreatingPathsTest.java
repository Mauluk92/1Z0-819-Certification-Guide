package it.mauluk92.java.c20;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class contain tests to validate rules about creating {@link Path} instances
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class CreatingPathsTest {

    /**
     * Since {@link Path} is an interface, we can't create an instance directly.
     * After all, interfaces don't have constructors! Java provides a number
     * of classes and methods that you can use to obtain Path objects.
     * The simplest and most straightforward way to obtain a Path object
     * is to use the static factory method defined within the Path interface.
     * It's easy to create a Path instance from String values, creating
     * relative Path and absolute file Path. The Path.of() method
     * also includes a varargs to pass additional path elements.
     */
    @Test
    @DisplayName("Using Path interface")
    public void pathInterface(){
        Path relativePath = Path.of("relative\\path", "file.txt");
        Path absolutePath = Path.of("c:\\absolute\\path", "file.txt");

        Assertions.assertInstanceOf(Path.class, relativePath);
        Assertions.assertInstanceOf(Path.class, absolutePath);
    }

    /**
     * The Path.of() method is actually new to Java 11.
     * Another way to obtain a {@link Path} instance is from
     * the {@link Paths} factory class.
     */
    @Test
    @DisplayName("Using Paths factory class")
    public void pathsFactoryClass(){
        Path relativePath = Paths.get("relative\\path", "file.txt");
        Path absolutePath = Paths.get("c:\\absolute\\path", "file.txt");

        Assertions.assertInstanceOf(Path.class, relativePath);
        Assertions.assertInstanceOf(Path.class, absolutePath);
    }

    /**
     * Another way to construct a Path using the Pats class
     * is with URI value. <em>A uniform resource identifier</em>
     * ({@link java.net.URI}) os a string of characters that identify a resource.
     * It begins with a schema that indicates the resource type,
     * followed by a path value. For example: file:// for locale file
     * systems.
     */
    @Test
    @DisplayName("Using URI class")
    public void uriClass() throws URISyntaxException {
        URI uriPath = new URI("file:/file.txt");

        Path pathWithFactory = Paths.get(uriPath);
        Path pathWithInterface = Path.of(uriPath);

        URI toUri = pathWithFactory.toUri();

        Assertions.assertInstanceOf(Path.class, pathWithFactory);
        Assertions.assertInstanceOf(Path.class, pathWithInterface);
        Assertions.assertInstanceOf(URI.class, toUri);
    }

    /**
     * NIO.2 makes extensive use of creating objects with
     * factory classes. As you saw already, the Paths class
     * creates instances of the Path interface. Likewise, the
     * {@link java.nio.file.FileSystems} class creates instance of the
     * abstract {@link java.nio.file.FileSystem} class.
     * The FileSystem class includes methods for working with the
     * file system directly. In fact, both Paths.get() and Path.of()
     * are actually shortcuts for this FileSystem method
     */
    @Test
    @DisplayName("Using FileSystem instance method")
    public void fileSystemInstanceMethod(){
        Path relativePath = FileSystems.getDefault().getPath("relative\\path", "file.txt");
        Path absolutePath = FileSystems.getDefault().getPath("c:\\absolute\\path", "file.txt");

        Assertions.assertInstanceOf(Path.class, relativePath);
        Assertions.assertInstanceOf(Path.class, absolutePath);
    }

    /**
     * Last but least, we cna obtain {@link Path} instances
     * using the legacy {@link java.io.File} class. In fact, we can
     * obtain a File object from a Path instance.
     */
    @Test
    @DisplayName("Legacy File object")
    public void legacyFile(){
        Path relativePath = FileSystems.getDefault().getPath("relative\\path", "file.txt");
        Path absolutePath = FileSystems.getDefault().getPath("c:\\absolute\\path", "file.txt");

        File relativeFile = relativePath.toFile();
        File absoluteFile = absolutePath.toFile();

        Path backToRelativePath = relativeFile.toPath();
        Path backToAbsolutePath = absoluteFile.toPath();

        Assertions.assertInstanceOf(Path.class, backToRelativePath);
        Assertions.assertInstanceOf(Path.class, backToAbsolutePath);
    }


}
