package it.mauluk92.java.c8;

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

    /**
     * The this reference refers to the current instance of the class and can be used
     * to access any members of the class, including inherited members. It can be used
     * in any instance method, constructor, and the instance initializer block.
     * Cannot be used where there is no implicit instance of the class (such as static methods
     * or initializers block)
     */
    @Test
    @DisplayName("Accessing the this reference, implicit instance")
    public void accessingThisReference(
            @CompileClasses(classesToCompile = "AccessingThisReference.java", sourcePath = "c8/creating_classes")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "AccessingThisReference")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * In Java, a variable or method can be defined in both a parent class and
     * a child class. When this happens, how do we reference the  version in the parent class
     * instead of the current class?
     * The super reference is similar to the this reference, except that the members should
     * be accessible only through inheritance
     */
    @Test
    @DisplayName("Calling the super reference")
    public void callingTheSuperReference(
            @CompileClasses(classesToCompile = "CallingTheSuperReference.java", sourcePath = "c8/creating_classes")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CallingTheSuperReference")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
