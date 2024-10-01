package it.mauluk92.java.c1;

import it.mauluk92.java.testutils.extension.CleanUpCompileTempDirectoryCallBack;
import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import it.mauluk92.java.testutils.extension.annotation.ExecuteJavaProgram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contains tests to validate the argument passing
 * to the main method
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, CleanUpCompileTempDirectoryCallBack.class})
public class WritingMainMethodTest {
    /**
     * This test ensures that the arguments passed are effectively
     * used by the program itself
     */
    @Test
    @DisplayName("Arguments can be passed to the main method, which acts as a gateway to the code")
    public void passArgumentsToMainMethod(
            @CompileClasses(classesToCompile = "PassArgumentsToMainMethod.java", sourcePath = "c1/writing_main_method")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "PassArgumentsToMainMethod", commandLineArguments = "Hello!")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }


}
