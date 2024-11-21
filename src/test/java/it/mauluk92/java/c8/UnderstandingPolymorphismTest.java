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
 * This class contains tests validates rules about polymorphism
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UnderstandingPolymorphismTest {

    /**
     * In Java, all objects are accessed by reference, so as a developer you never
     * have direct access to the object itself.
     * Conceptually, though, you should consider the object as the entity,
     * that exists in memory, allocated by the java runtime environment.
     * Regardless of the type of the reference you have for the object in memory,
     * the object itself doesn't change.
     */
    @Test
    @DisplayName("Object type reference determines properties and method accessibles")
    public void objectTypeReference(
            @CompileClasses(classesToCompile = "ObjectTypeReference.java", sourcePath = "c8/understanding_polymorphism")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Next, we can't assign an object to a subtype without an explicit cast
     */
    @Test
    @DisplayName("Cannot assign object to subtype without explicit cast")
    public void explicitCastCompilationError(
            @CompileClasses(classesToCompile = "ExplicitCastCompilationError.java", sourcePath = "c8/understanding_polymorphism")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * An explicit cast on a subtype target, if compatible, will compile
     */
    @Test
    @DisplayName("Explicit cast with compatible type will compile")
    public void explicitCastWithCompatibleType(
            @CompileClasses(classesToCompile = "ExplicitCastWithCompatibleType.java", sourcePath = "c8/understanding_polymorphism")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * The compiler disallow casts to an unrelated class
     */
    @Test
    @DisplayName("Compilation error on incompatible type unrelated class cast")
    public void unrelatedClassCast(
            @CompileClasses(classesToCompile = "UnrelatedClassCast.java", sourcePath = "c8/understanding_polymorphism")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * At runtime, an invalid cast of a reference to an unrelated type
     * results in a ClassCastException being thrown
     */
    @Test
    @DisplayName("Invalid runtime cast")
    public void unrelatedRuntimeInvalidCast(
            @CompileClasses(classesToCompile = "UnrelatedRuntimeInvalidCast.java", sourcePath = "c8/understanding_polymorphism")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * instanceof operator can be used to check whether an object
     * belongs to a particular class or interface to prevent ClassCastExceptions
     * at runtime.
     */
    @Test
    @DisplayName("instanceof check")
    public void instanceofOperatorCheck(
            @CompileClasses(classesToCompile = "InstanceOfOperatorCheck.java", sourcePath = "c8/understanding_polymorphism")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * instanceof operator will throw a compilation error with casts
     * of unrelated types belonging to different hierarchies
     */
    @Test
    @DisplayName("instanceof compilation error on unrelated class cast")
    public void unrelatedInstanceOfOperatorApplication(
            @CompileClasses(classesToCompile = "UnrelatedInstanceOfOperatorApplication.java", sourcePath = "c8/understanding_polymorphism")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * In Java, polymorphism states that when you override a method, you replace all
     * calls to it, even those defined in the parent class.
     */
    @Test
    @DisplayName("Polymorphism and method overriding")
    public void polymorphismMethodOverriding(
            @CompileClasses(classesToCompile = "PolymorphismMethodOverriding.java", sourcePath = "c8/understanding_polymorphism")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "PolymorphismMethodOverriding")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Hiding members is not a form of polymorphism since the methods and variables
     * maintain their individual properties. Unlike method overriding, hiding is very sensitive
     * to the reference type and location where the member is being used
     */
    @Test
    @DisplayName("Hiding members")
    public void hidingMembers(
            @CompileClasses(classesToCompile = "HidingMembers.java", sourcePath = "c8/understanding_polymorphism")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "HidingMembers")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

}
