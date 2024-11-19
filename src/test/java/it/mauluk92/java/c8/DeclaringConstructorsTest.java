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
 * This class contains tests to validate rules about constructors and initialization inside a class
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class DeclaringConstructorsTest {

    /**
     * A valid constructor declaration must have its name that match
     * the class name and does not have any return type
     */
    @Test
    @DisplayName("Valid constructor declaration")
    public void validConstructorDeclaration(
            @CompileClasses(classesToCompile = "ValidConstructorDeclaration.java", sourcePath = "c8/declaring_constructors")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * This test shows that a valid constructor declaration must not include a return type.
     * Otherwise, it will not be considered a constructor but a method
     */
    @Test
    @DisplayName("Not a constructor")
    public void notAConstructor(
            @CompileClasses(classesToCompile = "NotAConstructor.java", sourcePath = "c8/declaring_constructors")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Constructor overloading can be achieved through multiple constructors
     * with different signatures (distinct list of parameters)
     */
    @Test
    @DisplayName("Valid constructor overloading")
    public void validConstructorOverloading(
            @CompileClasses(classesToCompile = "ValidConstructorOverloading.java", sourcePath = "c8/declaring_constructors")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Two constructors with same signatures cannot co-exist in the same class,
     * making the code to not compile
     */
    @Test
    @DisplayName("Invalid constructor overloading")
    public void invalidConstructorOverloading(
            @CompileClasses(classesToCompile = "InvalidConstructorOverloading.java", sourcePath = "c8/declaring_constructors")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * If you don't include any constructor explicitly in your class,
     * the compiler will provide a default no-arg constructor for you
     */
    @Test
    @DisplayName("Default no arg constructor")
    public void defaultConstructor(
            @CompileClasses(classesToCompile = "DefaultConstructor.java", sourcePath = "c8/declaring_constructors")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "DefaultConstructor")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Writing out explicitly a constructor removes
     * the no-args constructor, which will not be present
     * anymore
     */
    @Test
    @DisplayName("No default no-arg constructor")
    public void noDefaultConstructor(
            @CompileClasses(classesToCompile = "NoDefaultConstructor.java", sourcePath = "c8/declaring_constructors")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "NoDefaultConstructor")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * We can call overloaded constructors inside other constructors
     * through this() keyword, but it must be at top of constructor declaration
     */
    @Test
    @DisplayName("Using this() inside constructor")
    public void usingThisInsideConstructor(
            @CompileClasses(classesToCompile = "UsingThisInsideConstructor.java", sourcePath = "c8/declaring_constructors")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "UsingThisInsideConstructor")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * We can call the constructors inherited from the parent class
     * through the keyword super. Must be the first statement inside
     * constructor declaration
     */
    @Test
    @DisplayName("Using super() inside constructor")
    public void usingSuperInsideConstructor(
            @CompileClasses(classesToCompile = "UsingSuperInsideConstructor.java", sourcePath = "c8/declaring_constructors")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "UsingSuperInsideConstructor")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Final fields must be initialized inside constructor declaration
     * or a compile-time error will occur
     */
    @Test
    @DisplayName("Final fields must be initialized")
    public void finalFields(
            @CompileClasses(classesToCompile = "FinalFields.java", sourcePath = "c8/declaring_constructors")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }



}
