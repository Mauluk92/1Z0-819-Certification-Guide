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
 * This class contains tests to validate rule about inheritance of methods and variables (overriding and hiding)
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class InheritingMembersTest {

    /**
     * Method in the child class must have the same signature as the method
     * in the parent class during overriding
     */
    @Test
    @DisplayName("Rule of same signature in overriding")
    public void sameSignatureRuleOverriding(
            @CompileClasses(classesToCompile = "SameSignatureRuleOverriding.java", sourcePath = "c8/inheriting_members")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Method in the child class must be at least as accessible as the method
     * in the parent class during overriding
     */
    @Test
    @DisplayName("Rule of accessibility in overriding")
    public void accessibilityRuleOverriding(
            @CompileClasses(classesToCompile = "AccessibilityRuleOverriding.java", sourcePath = "c8/inheriting_members")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
    /**
     * The method may not declare a checked exception that is
     * new or broader than the class of any exception declared in
     * the parent class method
     */

    @Test
    @DisplayName("Checked exception rule in overriding")
    public void exceptionRuleOverriding(
            @CompileClasses(classesToCompile = "ExceptionRuleOverriding.java", sourcePath = "c8/inheriting_members")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * If the method return a type, it must be a covariant type of the
     * return type of the parent class method
     */
    @Test
    @DisplayName("Covariant return type rule in overriding")
    public void covariantReturnTypeRuleOverriding(
            @CompileClasses(classesToCompile = "CovariantReturnTypeRuleOverriding.java", sourcePath = "c8/inheriting_members")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * You cannot overload methods by changing the generic type
     * due to type erasure. For the same reason, you also cannot
     * overload a generic method in a parent class
     */
    @Test
    @DisplayName("Cannot overload generic type method in a parent class")
    public void overloadingGenericMethodParent(
            @CompileClasses(classesToCompile = "OverloadingGenericMethodParent.java", sourcePath = "c8/inheriting_members")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * On the other hand, you can override a method with generic parameters, but
     * you must match the signature exactly including the generic type
     */
    @Test
    @DisplayName("Overriding a generic method")
    public void overridingGenericMethod(
            @CompileClasses(classesToCompile = "OverridingGenericMethod.java", sourcePath = "c8/inheriting_members")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * When you're working with overriden methods that
     * returns generics, the return values must be covariant
     * In terms of generics, this means that the return type
     * of the class or interface declared in the overriding
     * method must be a subtype of the class defined in the parent class.
     * The generic parameter type must match its parent exactly
     */
    @Test
    @DisplayName("Valid override of generic return type")
    public void validGenericReturnTypeOverride(
            @CompileClasses(classesToCompile = "ValidGenericReturnTypeOverride.java", sourcePath = "c8/inheriting_members")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * This case does not compile, since the return type to be covariant,
     * the generic type must match the one of the parent
     */
    @Test
    @DisplayName("Valid override of generic return type")
    public void invalidGenericReturnTypeOverride(
            @CompileClasses(classesToCompile = "InvalidGenericReturnTypeOverride.java", sourcePath = "c8/inheriting_members")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * In Java, you can't override a private method since they are not inherited.
     * But the child can redefine its own version of the method. It just means it is not an overriden
     * version of the parent class method
     */
    @Test
    @DisplayName("Redefining private methods allowed")
    public void redefiningPrivateMethods(
            @CompileClasses(classesToCompile = "RedefiningPrivateMethods.java", sourcePath = "c8/inheriting_members")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * A hidden method occurs when a child class defines a static method with the same
     * name and signature as an inherited static method defined in a parent class.
     * Both method should be marked as static if the code is to compile.
     */
    @Test
    @DisplayName("Hiding static methods")
    public void hidingStaticMethods(
            @CompileClasses(classesToCompile = "HidingStaticMethods.java", sourcePath = "c8/inheriting_members")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Final methods are used to enforce certain rules or behavior inside a class.
     * Overriding a final method will result in a compilation error
     */
    @Test
    @DisplayName("Overriding final methods result in compilation error")
    public void overridingFinalMethods(
            @CompileClasses(classesToCompile = "OverridingFinalMethods.java", sourcePath = "c8/inheriting_members")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Java doesn't allow variables to be overriden, but they can be hidden.
     * A hidden variable occurs when a child class defines a variable with the same
     * name as an inherited variable defined in the parent class. This creates two distinct copies
     * of the variable within an instance of the child class: one instance variable
     * in the parent and one in the child
     */
    @Test
    @DisplayName("Hiding instance variables")
    public void hidingVariables(
            @CompileClasses(classesToCompile = "HidingVariables.java", sourcePath = "c8/inheriting_members")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "HidingVariables")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }



}
