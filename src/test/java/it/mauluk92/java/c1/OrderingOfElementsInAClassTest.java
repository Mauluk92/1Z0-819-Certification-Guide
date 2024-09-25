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
 * This class contains test to ensure that correct order
 * of elements inside a class is needed in order to compile
 */
public class OrderingOfElementsInAClassTest {

    /**
     * The correct order of elements inside a class, where a package is
     * optional, imports are optional if no classes are imported
     * and a class definition is mandatory
     * @param outputDir outputDir the temporary directory used to store the compilation output
     * @throws IOException if an I/O error occurs while accessing the file
     */
    @Test
    @DisplayName("Correct order of element in a class is PIC (Package, Imports, Class)")
    public void correctOrderOfElementsTest(@TempDir Path outputDir) throws IOException {
        Path fileToCompile = new ClassPathResource("c1/ordering_of_elements_in_a_class/CorrectOfOrderInAClass.java").getFile().toPath();
        Assertions.assertEquals(0, JavaFacade.compileWithoutSourcePath(outputDir.toString(), fileToCompile.toString()));
    }

    /**
     * Incorrect order won't compile
     * @param outputDir outputDir the temporary directory used to store the compilation output
     * @throws IOException if an I/O error occurs while accessing the file
     */
    @Test
    @DisplayName("Incorrect order of elements in a class must not compile")
    public void incorrectOrderOfElementsMustNotCompileTest(@TempDir Path outputDir) throws IOException {
        Path fileToCompile = new ClassPathResource("c1/ordering_of_elements_in_a_class/IncorrectOrderOfElementsMustNotCompile.java").getFile().toPath();
        Assertions.assertEquals(1, JavaFacade.compileWithoutSourcePath(outputDir.toString(), fileToCompile.toString()));
    }
}
