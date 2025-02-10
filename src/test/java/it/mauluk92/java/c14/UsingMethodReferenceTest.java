package it.mauluk92.java.c14;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contain tests to validate rules about using methods references
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UsingMethodReferenceTest {

    /**
     * A static method reference can be used in place of
     * a lambda in certain circumstances
     */
    @Test
    @DisplayName("Calling static method reference")
    public void callingStaticMethods(
            @CompileClasses(classesToCompile = "CallingStaticMethods.java", sourcePath = "c14/using_method_reference")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Calling instance method on a particular object can
     * be done with a method reference
     */
    @Test
    @DisplayName("Calling instance method on object via reference")
    public void callingInstanceMethodOnObject(
            @CompileClasses(classesToCompile = "CallingInstanceMethodOnObject.java", sourcePath = "c14/using_method_reference")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Calling instance method on a parameter
     * can be done with a method reference
     */
    @Test
    @DisplayName("Calling instance method on parameter via reference")
    public void callingInstanceMethodOnParameter(
            @CompileClasses(classesToCompile = "CallingInstanceMethodOnParameter.java", sourcePath = "c14/using_method_reference")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Calling constructor
     * can be done with a method reference
     */
    @Test
    @DisplayName("Calling constructor via reference")
    public void callingConstructor(
            @CompileClasses(classesToCompile = "CallingConstructor.java", sourcePath = "c14/using_method_reference")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }


}
