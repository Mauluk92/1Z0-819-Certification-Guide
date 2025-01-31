package it.mauluk92.java.c10;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contains tests to validate rules about exceptions and method that throw them
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class CallingMethodsThatThrowsExceptionTest {

    /**
     * A try catch block will raise a compilation error
     * if no exception of the corresponding type
     * is being thrown or declared in a method inside the block itself
     */
    @Test
    @DisplayName("Try catch block syntax invalid")
    public void invalidTryCatchBlock(
            @CompileClasses(classesToCompile = "InvalidTryCatchBlock.java", sourcePath = "c10/calling_methods_that_throws_exception")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }


    /**
     * An overridden method cannot declare an exception if
     * the parent method do not declare any exception
     */
    @Test
    @DisplayName("Invalid Overridden Method")
    public void invalidOverriddenMethodException(
            @CompileClasses(classesToCompile = "InvalidOverriddenMethodException.java", sourcePath = "c10/calling_methods_that_throws_exception")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * But can declare in its throws clause a more specific exception than its parent and overridden method
     */
    @Test
    @DisplayName("Valid overridden method exception")
    public void validOverriddenMethodException(
            @CompileClasses(classesToCompile = "ValidOverriddenMethodException.java", sourcePath = "c10/calling_methods_that_throws_exception")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }




}
