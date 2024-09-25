package it.mauluk92.java.c1;

import it.mauluk92.java.testutils.JavaFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Path;

/**
 * This class contains tests to validate the use of
 * jar files inside other programs
 */
public class UsingJarsTest {
    /**
     * This test ensures that a jar can be used in the classpath of compilation
     * of another class as external library
     * @param outputDir the temporary directory used to store the compilation output
     * @param jarFilePath the temporary directory used to store the jar compilation output
     * @throws IOException if an I/O error occurs while accessing the file
     */
    @Test
    @DisplayName("Jars can be used in the classpath as library for other code")
    public void creatingJarFile(@TempDir Path outputDir, @TempDir Path jarFilePath) throws IOException {
        Path fileToCompile = new ClassPathResource("c1/using_jars/creating_jar_file/jar_file/JarFile.java").getFile().toPath();
        Path sourcePath = new ClassPathResource("c1/using_jars/creating_jar_file").getFile().toPath();
        Assertions.assertEquals(0, JavaFacade.compileWithoutSourcePath(outputDir.toString(), fileToCompile.toString()));
        Assertions.assertEquals(0, JavaFacade.createNonExecutableJar(jarFilePath.toString(), outputDir.toString(), "Library.jar"));
        Assertions.assertEquals(0, JavaFacade.compile(outputDir.toString(), jarFilePath.resolve("Library.jar").toString(), sourcePath.toString(), "CreatingJarFile.java"));
        Assertions.assertEquals(0, JavaFacade.runWithoutArgs(outputDir.toString(), "CreatingJarFile"));
    }
}
