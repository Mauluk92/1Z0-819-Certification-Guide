package it.mauluk92.java.c7;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import it.mauluk92.java.testutils.extension.annotation.ExecuteJavaProgram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class OverloadingTest {

    /**
     * Overloaded methods differ only in parameter list, they have the same method name.
     * Return type, access modifier and exception list are irrelevant to overloading
     */
    @Test
    @DisplayName("Overloading means having same method name but different signature")
    public void overloadedMethods(
            @CompileClasses(classesToCompile = "OverloadedMethods.java", sourcePath = "c7/overloading")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Return  type do not participate in overloading. This means that any method
     * having the same method name and method parameters, but differing only in return type
     * won't compile
     */
    @Test
    @DisplayName("Overloading means having same method name but different signature")
    public void invalidOverloadedMethods(
            @CompileClasses(classesToCompile = "InvalidOverloadedMethods.java", sourcePath = "c7/overloading")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * From the point of view of overloading, varargs and array are the same type
     */
    @Test
    @DisplayName("Varargs and arrays are the same type")
    public void invalidOverloadedMethodsVarargs(
            @CompileClasses(classesToCompile = "InvalidOverloadedMethodsVarargs.java", sourcePath = "c7/overloading")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * If a Java primitive wrapper is being used, Java will find the closest match
     * to the parameter
     */
    @Test
    @DisplayName("Java will auto-box only when necessary")
    public void overloadedMethodWithAutoboxing(
            @CompileClasses(classesToCompile = "OverloadedMethodWithAutoboxing.java", sourcePath = "c7/overloading")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "OverloadedMethodWithAutoboxing" )
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The same rules holds for reference types.
     * The closest match is being used for the overloaded method
     */
    @Test
    @DisplayName("Java will use the closest match to the reference type")
    public void overloadedMethodWithReferences(
            @CompileClasses(classesToCompile = "OverloadedMethodWithReferences.java", sourcePath = "c7/overloading")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "OverloadedMethodWithReferences" )
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Due to type erasure, it's not possible to use generics on overloaded method if it happens to be reduced
     * to the same signature after type erasure
     */
    @Test
    @DisplayName("Type erasure will prevent from defining two methods with list argument even if they happen to have different parameter type")
    public void invalidOverloadedMethodsGenerics(
            @CompileClasses(classesToCompile = "InvalidOverloadedMethodsGenerics.java", sourcePath = "c7/overloading")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * But, unlike generics, arrays with different type are permitted and define their own type of data.
     * Since it is allowed, this code will compile
     */
    @Test
    @DisplayName("Overloaded method with arrays won't cause any troubles to the compiler")
    public void validOverloadedMethodsArrays(
            @CompileClasses(classesToCompile = "ValidOverloadedMethodsArrays.java", sourcePath = "c7/overloading")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

}
