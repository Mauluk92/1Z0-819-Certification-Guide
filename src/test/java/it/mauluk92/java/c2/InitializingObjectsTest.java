package it.mauluk92.java.c2;

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
 * This class contains tests to validate the rule for correct definition of a constructor
 * used to initialize variables inside an object and other constructs to initialize
 * variables inside a class
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, CleanUpCompileTempDirectoryCallBack.class})
public class InitializingObjectsTest {

    /**
     * This test ensures that correct definition of constructor
     * allow to initialize an object upon invocation with new
     */
    @Test
    @DisplayName("A constructor is defined in order to initialize an object")
    public void definingYourOwnConstructor(
            @CompileClasses(classesToCompile = "DefiningYourOwnConstructor.java", sourcePath = "c2/initializing_objects")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "DefiningYourOwnConstructor")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * This test ensures that field initialization is equally valid as constructor initialization.
     * Also, inside any field initialization any value can be read if it was previously initialized
     */
    @Test
    @DisplayName("Inside an initialization statement it is possible to read values from previous initialized values")
    public void readingAndWritingFields(
            @CompileClasses(classesToCompile = "ReadingAndWritingFields.java", sourcePath = "c2/initializing_objects")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ReadingAndWritingFields")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * This test ensures that initialization blocks are an equally valid alternative to initialize field variables
     */
    @Test
    @DisplayName("Objects can also be initialized with initialization blocks, which are run before any code inside the constructor")
    public void initializationBlock(
            @CompileClasses(classesToCompile = "InitializationBlock.java", sourcePath = "c2/initializing_objects")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "InitializationBlock")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);

    }

    /**
     * Firstly, fields initialization statements and initialization blocks are run in the order
     * in which they appear inside the source code. After that, the code inside the invoked constructor is executed
     */
    @Test
    @DisplayName("The order of initialization follows certain rules")
    public void orderOfInitialization(
            @CompileClasses(classesToCompile = "OrderOfInitialization.java", sourcePath = "c2/initializing_objects")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "OrderOfInitialization")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
