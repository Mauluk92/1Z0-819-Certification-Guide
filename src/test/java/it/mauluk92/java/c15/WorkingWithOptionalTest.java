package it.mauluk92.java.c15;

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
 * This class contain tests to validate rules about Optional wrappers
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class WorkingWithOptionalTest {

    /**
     * How do we express this "don't know" or "not applicable" answer
     * in Java? We use the Optional of type. An Optional is created using a
     * factory. You can either request an empty Optional or pass a value
     * for the Optional to wrap.
     */
    @Test
    @DisplayName("Creating an Optional")
    public void creatingAnOptional(
            @CompileClasses(classesToCompile = "CreatingAnOptional.java", sourcePath = "c15/working_with_optional")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CreatingAnOptional")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * There are certain instance methods useful for optionals
     */
    @Test
    @DisplayName("Optional instance method")
    public void optionalInstanceMethod(
            @CompileClasses(classesToCompile = "OptionalInstanceMethod.java", sourcePath = "c15/working_with_optional")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "OptionalInstanceMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
