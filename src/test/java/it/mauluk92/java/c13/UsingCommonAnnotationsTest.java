package it.mauluk92.java.c13;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contain tests to validate rules about using common annotations
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UsingCommonAnnotationsTest {

    /**
     * Marking a method with the annotation @Override
     * will raise a compilation error if the method
     * does not override any method from superclass
     */
    @Test
    @DisplayName("@Override on a non overridden method will generate compilation error")
    public void usingAnnotationOverride(
            @CompileClasses(classesToCompile = "UsingAnnotationOverride.java", sourcePath = "c13/using_common_annotations")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Marking an interface with the annotation @FunctionalInterface
     * enforces the SAM rule on an interface and will raise
     * a compilation error if not enforced
     */
    @Test
    @DisplayName("@FunctionalInterface enforces SAM rule")
    public void usingAnnotationFunctionalInterface(
            @CompileClasses(classesToCompile = "UsingAnnotationFunctionalInterface.java", sourcePath = "c13/using_common_annotations")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Marking a method with the annotation @Deprecated
     * will generate a compile-time warning about the use of such a class
     */
    @Test
    @DisplayName("@Deprecated used to specify that a library/class is to be retired")
    public void usingAnnotationDeprecated(
            @CompileClasses(classesToCompile = "UsingAnnotationDeprecated.java", sourcePath = "c13/using_common_annotations")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }
}
