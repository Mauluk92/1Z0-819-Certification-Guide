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
 * This class contain tests to validate rules about creation of annotations
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class CreatingCustomAnnotationsTest {

    /**
     * Annotations are used to specify metadata, data about other data.
     * We can create an annotation with @interface annotation
     */
    @Test
    @DisplayName("Creating a marker empty annotation")
    public void creatingMarkerAnnotation(
            @CompileClasses(classesToCompile = "CreatingMarkerAnnotation.java", sourcePath = "c13/creating_custom_annotations")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Annotations may contain elements, which are key-value pairs.
     * Any element without a default is considered mandatory
     */
    @Test
    @DisplayName("Specifying a required element")
    public void specifyingARequiredElement(
            @CompileClasses(classesToCompile = "SpecifyingARequiredElement.java", sourcePath = "c13/creating_custom_annotations")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * In annotations the keyword default is used to provide
     * an optional element
     */
    @Test
    @DisplayName("Providing an optional element")
    public void providingAnOptionalElement(
            @CompileClasses(classesToCompile = "ProvidingAnOptionalElement.java", sourcePath = "c13/creating_custom_annotations")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * The value of an element must be a non-null constant expression
     */
    @Test
    @DisplayName("Providing an element value")
    public void providingAnElementValue(
            @CompileClasses(classesToCompile = "ProvidingAnElementValue.java", sourcePath = "c13/creating_custom_annotations")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Annotations elements should be public (they are
     * implicitly public)
     */
    @Test
    @DisplayName("Applying elements modifier")
    public void applyingElementModifier(
            @CompileClasses(classesToCompile = "ApplyingElementModifier.java", sourcePath = "c13/creating_custom_annotations")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Annotations can declare constants like interface.
     * They are implicitly public static final
     */
    @Test
    @DisplayName("Adding a constant  variable")
    public void addingAConstantVariable(
            @CompileClasses(classesToCompile = "AddingAConstantVariable.java", sourcePath = "c13/creating_custom_annotations")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }
}
