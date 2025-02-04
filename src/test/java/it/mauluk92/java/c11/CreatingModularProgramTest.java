package it.mauluk92.java.c11;

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
 * This class contain tests to validate rules and information about modules
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class CreatingModularProgramTest {


    /**
     * A module is a group of one or more packages
     * plus a special file called module-info.java.
     */
    @Test
    @DisplayName("Exploring the module")
    public void exploringTheModule(
            @CompileClasses(classesToCompile = {
                    "internal/module-info.java",
                    "internal/nested/deep/InternalNestedDeepFile.java"
            }, sourcePath = "c11/creating_modular_program")
            Integer outputCompilation,
            @ExecuteJavaProgram(moduleName = "internal.nested.deep/internal.nested.deep.InternalNestedDeepFile")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Modules provide another layer of access control
     * to specify other packages. This stronger form of
     * encapsulation really does create internal packages
     */
    @Test
    @DisplayName("Better access control")
    public void betterAccessControl(
            @CompileClasses(classesToCompile = {
                    "internal/module-info.java",
                    "internal/nested/deep/InternalNestedDeepFile.java"
            }, sourcePath = "c11/creating_modular_program")
            Integer outputCompilation,
            @ExecuteJavaProgram(moduleName = "internal.nested.deep/internal.nested.deep.InternalNestedDeepFile")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Modules enforces the uniqueness
     * of a package provided inside itself
     */
    @Test
    @DisplayName("Unique package enforcement")
    public void uniquePackageEnforcement(
            @CompileClasses(classesToCompile = {
                    "internal/module-info.java",
                    "internal/nested/deep/InternalNestedDeepFile.java"
            }, sourcePath = "c11/creating_modular_program")
            Integer outputCompilation,
            @ExecuteJavaProgram(moduleName = "internal.nested.deep/internal.nested.deep.InternalNestedDeepFile")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }


}
