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
 * This class contain tests to validate rules about using and applying annotations
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class ApplyingAnnotationsTest {

    /**
     * Annotation can be applied to any Java declaration
     * including the following:
     * Classes, Interfaces, enums and modules.
     * Variables (Static, instance, local).
     * Methods and constructors.
     * Method, constructor, and lambda parameters.
     * Cast expressions.
     * Other annotations.
     */
    @Test
    @DisplayName("Using Annotations in declarations")
    public void usingAnnotationsInDeclarations(
            @CompileClasses(classesToCompile = "UsingAnnotationsInDeclarations.java", sourcePath = "c13/applying_annotations")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * A value element is used as a shorthand to specify an element
     * without its key (name). To use this shorthand the following conditions
     * are to be met:
     * 1) The element name must be "value".
     * 2) The annotation must not contain other required elements.
     * 3) The usage of annotation must not provide other element value.
     */
    @Test
    @DisplayName("Using value element in Annotations")
    public void valueElement(
            @CompileClasses(classesToCompile = "ValueElement.java", sourcePath = "c13/applying_annotations")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * An array of value on an element can be specified through
     * two different notations (a shorthand and a complete form)
     */
    @Test
    @DisplayName("Using value list in element in Annotations")
    public void valueElementArray(
            @CompileClasses(classesToCompile = "ValueElementArray.java", sourcePath = "c13/applying_annotations")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }
}
