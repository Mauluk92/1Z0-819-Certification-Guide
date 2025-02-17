package it.mauluk92.java.c16;

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
 * This class contain tests to validate rules about try with resource statement
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class TryWithResourceTest {

    /**
     * First rule: try with resources statements
     * require resources that implements the AutoClosable
     * interface
     */
    @Test
    @DisplayName("AutoClosable interface")
    public void autoClosableInterface(
            @CompileClasses(classesToCompile = "AutoClosableInterface.java", sourcePath = "c16/try_with_resource")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Second rule: try with resources statements
     * can include multiple resources which are closed
     * in the reverse order of declaration
     */
    @Test
    @DisplayName("Multiple resources rule")
    public void multipleResourcesRule(
            @CompileClasses(classesToCompile = "MultipleResourcesRule.java", sourcePath = "c16/try_with_resource")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "MultipleResourcesRule")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Third rule: resources declared within
     * a try with resources statement are in scope
     * only within the try block
     */
    @Test
    @DisplayName("Try with resource resource scope")
    public void tryWithResourceScope(
            @CompileClasses(classesToCompile = "TryWithResourceScope.java", sourcePath = "c16/try_with_resource")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Resources can be declared outside try with resource and used
     * inside a try with resource only if the resource is
     * effectively final or final
     */
    @Test
    @DisplayName("Try with resource final")
    public void tryWithResourceFinal(
            @CompileClasses(classesToCompile = "TryWithResourceFinal.java", sourcePath = "c16/try_with_resource")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
