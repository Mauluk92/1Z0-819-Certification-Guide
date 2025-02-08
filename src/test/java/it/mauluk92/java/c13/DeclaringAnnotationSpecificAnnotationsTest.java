package it.mauluk92.java.c13;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import it.mauluk92.java.testutils.extension.annotation.ExecuteJavaProgram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contain tests to validate rules about declaring annotation specific annotations
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class DeclaringAnnotationSpecificAnnotationsTest {

    /**
     * Annotation @Target can be used to limit the usage of an annotation
     * to corresponding declaration or elements
     */
    @Test
    @DisplayName("@Target limit the usage of the annotation")
    public void limitingUsageWithAnnotationTarget(
            @CompileClasses(classesToCompile = "LimitingUsageWithAnnotationTarget.java", sourcePath = "c13/declaring_annotation_specific_annotations")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }


    /**
     * Annotation @Retention can be used to specify the policy of retention
     * of the given annotation, whether it may be stored at runtime or not for example
     **/
    @Test
    @DisplayName("@Retention specify the retention policy of annotation")
    public void retentionPolicyAnnotation(
            @CompileClasses(classesToCompile = "RetentionPolicyAnnotation.java", sourcePath = "c13/declaring_annotation_specific_annotations")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Annotation @Documented makes the annotation present to users
     * of API in the generated JavaDoc
     **/
    @Test
    @DisplayName("@Documented specify the presence of annotation in other elements")
    public void documentedAnnotation(
            @CompileClasses(classesToCompile = "DocumentedAnnotation.java", sourcePath = "c13/declaring_annotation_specific_annotations")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Annotation @Inherited means annotation will be
     * inherited to subclass if applied to any Type
     **/
    @Test
    @DisplayName("@Inherited specify the presence of annotation in subclasses")
    public void inheritedAnnotation(
            @CompileClasses(classesToCompile = "InheritedAnnotation.java", sourcePath = "c13/declaring_annotation_specific_annotations")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "InheritedAnnotation")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Annotation @Repeatable is used whenever we want
     * to use the same annotation more than once on the same place
     * (introduced in Java 8)
     **/
    @Test
    @DisplayName("@Repeatable annotation signals that the same annotation may be repeated")
    public void repeatableAnnotation(
            @CompileClasses(classesToCompile = "RepeatableAnnotation.java", sourcePath = "c13/declaring_annotation_specific_annotations")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }
}
