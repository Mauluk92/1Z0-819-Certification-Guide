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
 * This class contains tests that validates the rules for
 * logical groupings of classes under package and import statements
 */
public class CreatingPackagesTest {
    /**
     * This test ensures that grouping classes under packages
     * and compiling them correctly, provides a logical grouping of classes
     * which can be accessed by other classes with import statements
     * @param outputDir the temporary directory used to store the compilation output
     * @throws IOException if an I/O error occurs while accessing the file
     */
    @Test
    @DisplayName("Classes can be grouped under packages with a package statement")
    public void groupingUnderPackages(@TempDir Path outputDir) throws IOException {
        String sourcePath = new ClassPathResource("c1/creating_packages/grouping_under_packages").getFile().getAbsolutePath();
        Assertions.assertEquals(0, JavaFacade.compileWithoutClassPath(outputDir.toString(),sourcePath , "packagea/ClassPackageA.java", "packageb/ClassPackageB.java"));
        Assertions.assertEquals(0, JavaFacade.runWithoutArgs(outputDir.toString(), "packageb.ClassPackageB"));

    }
}
