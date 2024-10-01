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
 * This class contains tests to validate rules regarding imports
 * and import conflicts
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UnderstandingImportsTest {

    /**
     * Test to ensure that a class external to java.lang package needs an import
     * in order to use that same class inside a program. This demonstrates
     * that import statement are necessary for compilation
     */
    @Test
    @DisplayName("Imports tell to the compiler where to find particular classes. Without them, it won't compile")
    public void withoutImportsMustNotCompile(
            @CompileClasses(classesToCompile = "WithoutImportsMustNotCompile.java", sourcePath = "c1/understanding_imports")
            Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Test to ensure that a class outside java.lang package, if imported correctly with
     * the proper statement, will compile successfully
     */
    @Test
    @DisplayName("Package act as address and imports tell the compiler where to find the given class")
    public void withImportsMustCompile(
            @CompileClasses(classesToCompile = "WithImportsMustCompile.java", sourcePath = "c1/understanding_imports")
            Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Test ensure that if two classes with the same name are imported with
     * import statement, the compiler will output an error since it cannot
     * possibly discriminate which class to use as a default
     */
    @Test
    @DisplayName("If two classes are imported with the same name, the compilation will not be successful")
    public void twoClassesSameNameMustNotCompile(
            @CompileClasses(classesToCompile = "TwoClassesSameNameMustNotCompile.java", sourcePath = "c1/understanding_imports")
            Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * This test ensures that if two classes are imported, one of which through wildcard and the
     * other through an explicit import statement, the program will compile.
     * This demonstrates that explicit imports override wildcard imports
     */
    @Test
    @DisplayName("If two classes with same name are imported, but only one with explicit import, then it will compile")
    public void explicitImportOverridesWildcardImport(
            @CompileClasses(classesToCompile = "ExplicitImportOverridesWildcardImport.java", sourcePath = "c1/understanding_imports")
            Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * This test ensures that two classes with same name can be used inside the same
     * program, if at least one of them uses a fully qualified name, which
     * makes the import statement not necessary
     */
    @Test
    @DisplayName("If one class is imported and the other is used with fully qualified name, it will compile")
    public void fullyQualifiedNameOverImport(
            @CompileClasses(classesToCompile = "FullyQualifiedNameOverImport.java", sourcePath = "c1/understanding_imports")
            Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }
}
