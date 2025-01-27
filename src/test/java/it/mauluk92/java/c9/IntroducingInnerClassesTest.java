package it.mauluk92.java.c9;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contains tests to validate rules about Inner Classes
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class IntroducingInnerClassesTest {

    /**
     * Inner classes can be defined inside other classes
     */
    @Test
    @DisplayName("Inner classes are defined inside other classes")
    public void definingInnerClasses(
            @CompileClasses(classesToCompile = "DefiningInnerClasses.java", sourcePath = "c9/introducing_inner_classes")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Inner classes can be defined private
     */
    @Test
    @DisplayName("Inner classes can be defined private")
    public void privateInnerClassAllowed(
            @CompileClasses(classesToCompile = "PrivateInnerClassAllowed.java", sourcePath = "c9/introducing_inner_classes")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Inner classes can be defined protected
     */
    @Test
    @DisplayName("Inner classes can be defined protected")
    public void protectedInnerClassAllowed(
            @CompileClasses(classesToCompile = "ProtectedInnerClassAllowed.java", sourcePath = "c9/introducing_inner_classes")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Inner classes cannot have static members
     */
    @Test
    @DisplayName("Inner classes cannot define static members")
    public void staticMembersNotAllowed(
            @CompileClasses(classesToCompile = "StaticMembersNotAllowed.java", sourcePath = "c9/introducing_inner_classes")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
