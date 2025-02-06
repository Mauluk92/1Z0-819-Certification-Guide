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
 * This class contain tests to validate rules about anonymous inner classes
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class AnonymousInnerClassTest {

    /**
     * Anonymous inner class are a short form of local classes
     * useful when you have a short implementation of an interface
     * or abstract class that will not be used anywhere else
     */
    @Test
    @DisplayName("Anonymous inner classes are a short form of local inner class")
    public void anonymousInnerClasses(
            @CompileClasses(classesToCompile = "AnonymousInnerClasses.java", sourcePath = "c12/anonymous_inner_class")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "AnonymousInnerClasses")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Anonymous inner class can also be defined inside parameter list of a method,
     * and variable declaration
     */
    @Test
    @DisplayName("Anonymous inner classes are can be define nearly everywhere they are needed")
    public void anonymousInnerClassDefinition(
            @CompileClasses(classesToCompile = "AnonymousInnerClassDefinition.java", sourcePath = "c12/anonymous_inner_class")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }
}
