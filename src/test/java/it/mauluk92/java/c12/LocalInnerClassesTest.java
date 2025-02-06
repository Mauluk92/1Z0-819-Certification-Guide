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
 * This class contain tests to validate rules about local inner classes
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class LocalInnerClassesTest {

    /**
     * Local inner classes can be created inside methods
     * and they go out of scope when the method returns
     */
    @Test
    @DisplayName("Local Inner classes exists only within methods")
    public void localInnerClassScope(
            @CompileClasses(classesToCompile = "LocalInnerClassScope.java", sourcePath = "c12/local_inner_classes")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "LocalInnerClassScope")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Local inner classes cannot be declared static
     */
    @Test
    @DisplayName("Local Inner classes cannot be declared static")
    public void localInnerClassStaticModifier(
            @CompileClasses(classesToCompile = "LocalInnerClassStaticModifier.java", sourcePath = "c12/local_inner_classes")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Local inner classes can access methods and fields from the enclosing class
     */
    @Test
    @DisplayName("Local Inner classes can access methods/fields from enclosing class")
    public void localClassAccessEnclosingMembers(
            @CompileClasses(classesToCompile = "LocalClassAccessEnclosingMembers.java", sourcePath = "c12/local_inner_classes")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "LocalClassAccessEnclosingMembers")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Local inner classes cannot access non final or non effectively final
     * local variables
     */
    @Test
    @DisplayName("Local Inner classes cannot access non effectively final or final variables")
    public void localClassFinalVariables(
            @CompileClasses(classesToCompile = "LocalClassFinalVariables.java", sourcePath = "c12/local_inner_classes")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
