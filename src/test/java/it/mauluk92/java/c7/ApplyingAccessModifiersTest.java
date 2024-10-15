package it.mauluk92.java.c7;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contains tests to validate rules about access modifiers and their level of exposure
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class ApplyingAccessModifiersTest {

    /**
     * Private is the strictest level of exposure of Java.
     * Fields or methods declared private can only be accessed from within a class
     */
    @Test
    @DisplayName("Private access method or fields are accessible only from within a class")
    public void privateAccessModifier(
            @CompileClasses(classesToCompile = "PrivateAccessModifier.java", sourcePath = "c7/applying_access_modifiers")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Default access means package-private access
     * Fields or methods declared package-private can only be accessed from classes within the same package
     */
    @Test
    @DisplayName("Default access method or fields are accessible only from within the same package")
    public void defaultAccessModifier(
            @CompileClasses(classesToCompile = {"package_a/ClassPackageA.java", "package_b/ClassPackageB.java"}, sourcePath = "c7/applying_access_modifiers/classes_under_same_package_default_access")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Protected access extends further the default package private access
     * Fields or methods declared protected can only be accessed from classes within the same package or from subclasses
     */
    @Test
    @DisplayName("Protected access method or fields are accessible only from within the same package or from subclasses")
    public void protectedAccessModifier(
            @CompileClasses(classesToCompile = {"package_a/ClassPackageA.java", "package_b/ClassPackageB.java"}, sourcePath = "c7/applying_access_modifiers/classes_under_same_package_protected_access")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Public access provides the maximum amount of exposure
     * Fields or methods declared public can be accessed everywhere
     */
    @Test
    @DisplayName("Public access method or fields are accessible from everywhere")
    public void publicAccessModifier(
            @CompileClasses(classesToCompile = {"package_a/ClassPackageA.java", "package_b/ClassPackageB.java"}, sourcePath = "c7/applying_access_modifiers/classes_under_same_package_public_access")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }
}
