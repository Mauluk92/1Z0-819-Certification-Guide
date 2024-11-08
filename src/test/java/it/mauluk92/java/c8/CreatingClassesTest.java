package it.mauluk92.java.c8;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contains tests to validate rules about creating classes with inheritance
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class CreatingClassesTest {

    /**
     * The extends keyword is used to express that the child class inherits the parent class
     * Then we can access any non-private members from its ancestor
     */
    @Test
    @DisplayName("Accessing non-private members from parent class")
    public void accessingNonPrivateMembersFromParent(
            @CompileClasses(classesToCompile = "AccessingNonPrivateMembersFromParent.java", sourcePath = "c8/creating_classes")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * We cannot access private members of a superclass in Java.
     * We must use only its non-private members (protected, public or package-private)
     */
    @Test
    @DisplayName("Accessing private members from parent class will not compile")
    public void accessingPrivateMembersFromParent(
            @CompileClasses(classesToCompile = "AccessingPrivateMembersFromParent.java", sourcePath = "c8/creating_classes")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
