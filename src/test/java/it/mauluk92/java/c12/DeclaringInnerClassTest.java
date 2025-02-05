package it.mauluk92.java.c12;

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
 * This class contain tests to validate rules about member inner classes
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class DeclaringInnerClassTest {

    /**
     * Inner classes modifiers allowed are:
     * private, package-private, protected and
     * public
     */
    @Test
    @DisplayName("Inner classes allow every modifier")
    public void allowedInnerClassModifier(
            @CompileClasses(classesToCompile = "AllowedInnerClassModifier.java", sourcePath = "c12/declaring_inner_class")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Inner classes can be marked final or abstract
     */
    @Test
    @DisplayName("Inner classes allow every modifier")
    public void finalAbstractInnerClass(
            @CompileClasses(classesToCompile = "FinalAbstractInnerClass.java", sourcePath = "c12/declaring_inner_class")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Inner classes can have static final fields but not static
     */
    @Test
    @DisplayName("Inner classes can't have static fields")
    public void staticFieldsInnerClass(
            @CompileClasses(classesToCompile = "StaticFieldsInnerClass.java", sourcePath = "c12/declaring_inner_class")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Inner classes can't have static methods
     */
    @Test
    @DisplayName("Inner classes can't have static methods")
    public void staticMethodInnerClass(
            @CompileClasses(classesToCompile = "StaticMethodInnerClass.java", sourcePath = "c12/declaring_inner_class")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Inner classes can access private members of outer class
     */
    @Test
    @DisplayName("Inner classes can access private members of outer class")
    public void innerClassCanAccessPrivateOuter(
            @CompileClasses(classesToCompile = "InnerClassCanAccessPrivateOuter.java", sourcePath = "c12/declaring_inner_class")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "InnerClassCanAccessPrivateOuter")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
