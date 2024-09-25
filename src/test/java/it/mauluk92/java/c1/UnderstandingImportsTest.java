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
 * This class contains tests to validate rules regarding imports
 * and import conflicts
 */
public class UnderstandingImportsTest {

    /**
     * Test to ensure that a class external to java.lang package needs an import
     * in order to use that same class inside a program. This demonstrates
     * that import statement are necessary for compilation
     * @param outputDir the temporary directory used to store the compilation output
     * @throws IOException if an I/O error occurs while accessing the file
     */
    @Test
    @DisplayName("Imports tell to the compiler where to find particular classes. Without them, it won't compile")
    public void withoutImportsMustNotCompile(@TempDir Path outputDir) throws IOException {
        Path fileToCompile = new ClassPathResource("c1/understanding_imports/WithoutImportsMustNotCompile.java").getFile().toPath();
        Assertions.assertNotEquals(0, JavaFacade.compileWithoutClassPath(outputDir.toString(), fileToCompile.toString(), fileToCompile.toString()));
    }

    /**
     * Test to ensure that a class outside java.lang package, if imported correctly with
     * the proper statement, will compile successfully
     * @param outputDir the temporary directory used to store the compilation output
     * @throws IOException if an I/O error occurs while accessing the file
     */
    @Test
    @DisplayName("Package act as address and imports tell the compiler where to find the given class")
    public void withImportsMustCompile(@TempDir Path outputDir) throws IOException {
        Path fileToCompile = new ClassPathResource("c1/understanding_imports/WithImportsMustCompile.java").getFile().toPath();
        Assertions.assertEquals(0, JavaFacade.compileWithoutSourcePath(outputDir.toString(), fileToCompile.toString()));
    }

    /**
     * Test ensure that if two classes with the same name are imported with
     * import statement, the compiler will output an error since it cannot
     * possibly discriminate which class to use as a default
     * @param outputDir the temporary directory used to store the compilation output
     * @throws IOException if an I/O error occurs while accessing the file
     */
    @Test
    @DisplayName("If two classes are imported with the same name, the compilation will not be successful")
    public void twoClassesSameNameMustNotCompile(@TempDir Path outputDir) throws IOException {
        Path fileToCompile = new ClassPathResource("c1/understanding_imports/TwoClassesSameNameMustNotCompile.java").getFile().toPath();
        Assertions.assertNotEquals(0, JavaFacade.compileWithoutSourcePath(outputDir.toString(), fileToCompile.toString()));
    }

    /**
     * This test ensures that if two classes are imported, one of which through wildcard and the
     * other through an explicit import statement, the program will compile.
     * This demonstrates that explicit imports override wildcard imports
     * @param outputDir the temporary directory used to store the compilation output
     * @throws IOException if an I/O error occurs while accessing the file
     */
    @Test
    @DisplayName("If two classes with same name are imported, but only one with explicit import, then it will compile")
    public void explicitImportOverridesWildcardImport(@TempDir Path outputDir) throws IOException {
        Path fileToCompile = new ClassPathResource("c1/understanding_imports/ExplicitImportOverridesWildcardImport.java").getFile().toPath();
        Assertions.assertEquals(0, JavaFacade.compileWithoutSourcePath(outputDir.toString(), fileToCompile.toString()));
    }

    /**
     * This test ensures that two classes with same name can be used inside the same
     * program, if at least one of them uses a fully qualified name, which
     * makes the import statement not necessary
     * @param outputDir the temporary directory used to store the compilation output
     * @throws IOException if an I/O error occurs while accessing the file
     */
    @Test
    @DisplayName("If one class is imported and the other is used with fully qualified name, it will compile")
    public void fullyQualifiedNameOverImport(@TempDir Path outputDir) throws IOException {
        Path fileToCompile = new ClassPathResource("c1/understanding_imports/FullyQualifiedNameOverImport.java").getFile().toPath();
        Assertions.assertEquals(0, JavaFacade.compileWithoutSourcePath(outputDir.toString(), fileToCompile.toString()));
    }
}
