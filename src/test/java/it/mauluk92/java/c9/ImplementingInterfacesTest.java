package it.mauluk92.java.c9;

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
 * This class contains tests to validate rules about interfaces
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class ImplementingInterfacesTest {

    /**
     * An interface is a datatype that cannot be instantiated
     * and marked with the interface keyword
     */
    @Test
    @DisplayName("Interfaces cannot be instantiated")
    public void cannotInstantiateAbstractClass(
            @CompileClasses(classesToCompile = "CannotInstantiateInterface.java", sourcePath = "c9/implementing_interfaces")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Top level types cannot be declared protected
     */
    @Test
    @DisplayName("Interfaces cannot be marked protected as any top level datatypes")
    public void cannotMarkInterfaceProtected(
            @CompileClasses(classesToCompile = "CannotMarkInterfaceProtected.java", sourcePath = "c9/implementing_interfaces")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Top level types cannot be declared private
     */
    @Test
    @DisplayName("Interfaces cannot be marked private as any top level datatypes")
    public void cannotMarkInterfacePrivate(
            @CompileClasses(classesToCompile = "CannotMarkInterfacePrivate.java", sourcePath = "c9/implementing_interfaces")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Interfaces can contain zero or more abstract methods
     */
    @Test
    @DisplayName("Interfaces can contain zero or more abstract methods")
    public void emptyInterfaceAllowed(
            @CompileClasses(classesToCompile = "EmptyInterfaceAllowed.java", sourcePath = "c9/implementing_interfaces")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Interfaces can extend any number of interfaces
     */
    @Test
    @DisplayName("Interfaces can extends any number of interfaces")
    public void extendingMultipleInterfaces(
            @CompileClasses(classesToCompile = "ExtendingMultipleInterfaces.java", sourcePath = "c9/implementing_interfaces")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Casting an interface reference into a concrete class may produce
     * a runtime exception if classes aren't related
     */
    @Test
    @DisplayName("Casting an interface to unrelated type produce runtime exception")
    public void unrelatedType(
            @CompileClasses(classesToCompile = "UnrelatedType.java", sourcePath = "c9/implementing_interfaces")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "UnrelatedType")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertNotEquals(0, outputExecution);
    }

    /**
     * If a class is final and unrelated to an interface
     * a compiler error is produced
     */
    @Test
    @DisplayName("Compiler error if concrete class is final and unrelated")
    public void finalConcreteUnrelatedClass (
            @CompileClasses(classesToCompile = "FinalConcreteUnrelatedClass.java", sourcePath = "c9/implementing_interfaces")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Interfaces accept methods with body with the following modifiers:
     * private, default, private static, static
     */
    @Test
    @DisplayName("Allowed modifiers in interface's methods with body")
    public void allowedBodyMethodInInterface (
            @CompileClasses(classesToCompile = "AllowedBodyMethodInInterface.java", sourcePath = "c9/implementing_interfaces")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Abstract method only in abstract classes or interfaces
     */
    @Test
    @DisplayName("Abstract methods are not allowed in concrete classes")
    public void abstractMethodsNotAllowedConcreteClasses (
            @CompileClasses(classesToCompile = "AbstractMethodsNotAllowedConcreteClasses.java", sourcePath = "c9/implementing_interfaces")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Abstract method cannot be marked private
     */
    @Test
    @DisplayName("Abstract methods cannot be marked private")
    public void privateAbstractMethodNotAllowed (
            @CompileClasses(classesToCompile = "PrivateAbstractMethodNotAllowed.java", sourcePath = "c9/implementing_interfaces")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Abstract method cannot be marked final
     */
    @Test
    @DisplayName("Abstract methods cannot be marked final")
    public void finalAbstractMethodNotAllowed (
            @CompileClasses(classesToCompile = "FinalAbstractMethodNotAllowed.java", sourcePath = "c9/implementing_interfaces")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Abstract method cannot contain a body
     */
    @Test
    @DisplayName("Abstract methods cannot contain a body")
    public void abstractMethodShouldNotHaveBody (
            @CompileClasses(classesToCompile = "AbstractMethodShouldNotHaveBody.java", sourcePath = "c9/implementing_interfaces")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Interface variables must be initialized since they are
     * assumed to be static, public and final
     */
    @Test
    @DisplayName("Interface variables should be initialized")
    public void interfaceVariableShouldBeInitialized (
            @CompileClasses(classesToCompile = "InterfaceVariableShouldBeInitialized.java", sourcePath = "c9/implementing_interfaces")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
