package it.mauluk92.java.c12;

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
 * This class contain tests to validate advanced rules about enums
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class WorkingWithEnumsAdvancedTest {

    /**
     * Enums can contain constructors, which are
     * implicitly private and called once during initialization for each enums
     */
    @Test
    @DisplayName("Adding constructors on enums")
    public void addingEnumConstructor(
            @CompileClasses(classesToCompile = "AddingEnumConstructor.java", sourcePath = "c12/working_with_enums_advanced")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "AddingEnumConstructor")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Enums can contain variables
     */
    @Test
    @DisplayName("Adding variable on enums")
    public void addingEnumVariable(
            @CompileClasses(classesToCompile = "AddingEnumVariable.java", sourcePath = "c12/working_with_enums_advanced")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "AddingEnumVariable")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Enums can contain methods
     */
    @Test
    @DisplayName("Adding methods on enums")
    public void addingEnumMethod(
            @CompileClasses(classesToCompile = "AddingEnumMethod.java", sourcePath = "c12/working_with_enums_advanced")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "AddingEnumMethod")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Enums constructors can only be private,
     * no other modifier is accepted
     */
    @Test
    @DisplayName("Non private constructor not admissible")
    public void nonPrivateConstructorNotAdmissible(
            @CompileClasses(classesToCompile = "NonPrivateConstructorNotAdmissible.java", sourcePath = "c12/working_with_enums_advanced")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Enums can contain abstract methods that each
     * enum must implement
     */
    @Test
    @DisplayName("Abstract methods on enums")
    public void addingAbstractMethods(
            @CompileClasses(classesToCompile = "AddingAbstractMethods.java", sourcePath = "c12/working_with_enums_advanced")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "AddingAbstractMethods")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
