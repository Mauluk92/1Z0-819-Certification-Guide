package it.mauluk92.java.c1;

import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contains tests to validate the rules related to class definitions
 * in Java files, specifically regarding public and non-public classes.
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class ClassesVsFilesTest {
    /**
     * Test to ensure that two public classes cannot be in the same file.
     * According to Java rules, only one public class is allowed per file,
     * and its name must match the file name.
     * This test verifies that the compilation fails when more than one public
     * class is present in a single file.
     */
    @Test
    @DisplayName("Two public classes cannot be in the same file")
    public void twoPublicClassesMustNotCompile(
            @CompileClasses(classesToCompile = "TwoPublicClass.java", sourcePath = "c1/classes_vs_files")
            Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }
    /**
     * Test to ensure that two non-public classes in the same file will compile successfully,
     * regardless of the names of the classes. In Java, non-public classes do not need to match
     * the file name, and multiple non-public classes can be present in a single file.
     */
    @Test
    @DisplayName("Two non public class in the same file will compile regardless of the name of classes")
    public void twoNonPublicClassesMustCompile(
            @CompileClasses(classesToCompile = "TwoNonPublicClass.java", sourcePath = "c1/classes_vs_files")
            Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }
    /**
     * Test to ensure that a file containing a public class and any number of
     * non-public classes will compile successfully. Java allows a public class to
     * coexist with multiple non-public classes in the same file, as long as the
     * public class's name matches the file name.
     */
    @Test
    @DisplayName("A file containing a public class with any number of non public class will compile")
    public void publicClassWithAnyNumberOfNonPublicClassesMustCompile(
            @CompileClasses(classesToCompile = "OnlyOnePublicClassAnyNonPublicClass.java", sourcePath = "c1/classes_vs_files")
            Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }
    /**
     * Test to ensure that if there is a public class in a file, the name of the
     * public class must match the file name. If the names do not match, the compilation
     * should fail, as per Java's naming conventions.
     */
    @Test
    @DisplayName("If there is a public class, its name must match the file name")
    public void publicClassMustMatchFileName(
            @CompileClasses(classesToCompile = "PublicClassMustMatchFileName.java", sourcePath = "c1/classes_vs_files")
            Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
