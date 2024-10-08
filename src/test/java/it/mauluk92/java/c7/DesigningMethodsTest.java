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

/**
 * This class contains tests to validate rules about method design
 * such as access modifiers, specifiers, return type, throw list and rules about identifiers
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class DesigningMethodsTest {

    /**
     * Access modifier are: public, default (package-private access), private, protected
     */
    @Test
    @DisplayName("Access modifier define the level of exposure of a method to application code")
    public void methodAccessModifiers(
            @CompileClasses(classesToCompile = "MethodAccessModifiers.java", sourcePath = "c7/designing_methods")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "MethodAccessModifiers") Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Optional specifiers are static, abstract, final, synchronized, native, strictfp
     */
    @Test
    @DisplayName("Specifiers are optional and specify more properties of method, such as static")
    public void methodOptionalSpecifiers(
            @CompileClasses(classesToCompile = "MethodOptionalSpecifiers.java", sourcePath = "c7/designing_methods")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "MethodOptionalSpecifiers") Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Return type can be either any java type or void, if the method do not return any object or primitive
     */
    @Test
    @DisplayName("Return type is mandatory, or alternatively, the void keyword")
    public void methodReturnType(
            @CompileClasses(classesToCompile = "MethodReturnType.java", sourcePath = "c7/designing_methods")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "MethodReturnType") Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Method names follow the same rules of all identifiers in Java
     */
    @Test
    @DisplayName("Method cannot start with numbers. Must have letters, numbers, $ or _")
    public void validMethodName(
            @CompileClasses(classesToCompile = "ValidMethodName1.java", sourcePath = "c7/designing_methods")
            Integer outputCompilation1,
            @CompileClasses(classesToCompile = "ValidMethodName2.java", sourcePath = "c7/designing_methods")
            Integer outputCompilation2,
            @CompileClasses(classesToCompile = "ValidMethodName3.java", sourcePath = "c7/designing_methods")
            Integer outputCompilation3,
            @CompileClasses(classesToCompile = "ValidMethodName4.java", sourcePath = "c7/designing_methods")
            Integer outputCompilation4
    ){
        Assertions.assertEquals(0, outputCompilation1);
        Assertions.assertNotEquals(0, outputCompilation2);
        Assertions.assertNotEquals(0, outputCompilation3);
        Assertions.assertNotEquals(0, outputCompilation4);
    }

    /**
     * Parameter list can have multiple parameters, with each type specified
     */
    @Test
    @DisplayName("Parameter list is optional, can be empty, or must contain parameter with the type")
    public void parameterList(
            @CompileClasses(classesToCompile = "ParameterList.java", sourcePath = "c7/designing_methods")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ParameterList") Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Exception list indicates that something may go wrong inside the body of method
     */
    @Test
    @DisplayName("Exception list is never mandatory, ma could be if exception is thrown by method and not caught")
    public void exceptionList(
            @CompileClasses(classesToCompile = "ExceptionList.java", sourcePath = "c7/designing_methods")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }









}
