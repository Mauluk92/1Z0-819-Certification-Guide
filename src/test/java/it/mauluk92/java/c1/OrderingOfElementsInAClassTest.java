package it.mauluk92.java.c1;

import it.mauluk92.java.testutils.extension.CleanUpCompileTempDirectoryCallBack;
import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contains test to ensure that correct order
 * of elements inside a class is needed in order to compile
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, CleanUpCompileTempDirectoryCallBack.class})
public class OrderingOfElementsInAClassTest {

    /**
     * The correct order of elements inside a class, where a package is
     * optional, imports are optional if no classes are imported
     * and a class definition is mandatory
     */
    @Test
    @DisplayName("Correct order of element in a class is PIC (Package, Imports, Class)")
    public void correctOrderOfElementsTest(
            @CompileClasses(classesToCompile = "CorrectOfOrderInAClass.java", sourcePath = "c1/ordering_of_elements_in_a_class")
            Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Incorrect order won't compile
     */
    @Test
    @DisplayName("Incorrect order of elements in a class must not compile")
    public void incorrectOrderOfElementsMustNotCompileTest(
            @CompileClasses(classesToCompile = "IncorrectOrderOfElementsMustNotCompile.java", sourcePath = "c1/ordering_of_elements_in_a_class")
            Integer outputCompilation
    ) {
        Assertions.assertEquals(1, outputCompilation);
    }
}
