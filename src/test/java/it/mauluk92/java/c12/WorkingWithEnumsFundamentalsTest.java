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
 * This class contain tests to validate rules about fundamentals of enums
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class WorkingWithEnumsFundamentalsTest {

    /**
     * Enums are useful whenever we need a fixed size of items
     * known at compile time. They are created with the enum keyword
     */
    @Test
    @DisplayName("Creating a simple enum with enum keyword")
    public void creatingSimpleEnum(
            @CompileClasses(classesToCompile = "CreatingSimpleEnum.java", sourcePath = "c12/working_with_enums_fundamentals")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Enums are like static constants and can
     * therefore, be confronted with == operator or with
     * the method equals()
     */
    @Test
    @DisplayName("Confronting enums")
    public void confrontingEnums(
            @CompileClasses(classesToCompile = "ConfrontingEnums.java", sourcePath = "c12/working_with_enums_fundamentals")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Enums can be cycled through with the for-each loop on its values()
     */
    @Test
    @DisplayName("Cycling through enums")
    public void cyclingThroughEnums(
            @CompileClasses(classesToCompile = "CyclingThroughEnums.java", sourcePath = "c12/working_with_enums_fundamentals")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CyclingThroughEnums")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Enums can be retrieved via the valueOf method
     * which accept a string as its parameter, which represent
     * the name of the enum to retrieve.
     */
    @Test
    @DisplayName("Valid use of valueOf method")
    public void valueOfValidUse(
            @CompileClasses(classesToCompile = "ValueOfValidUse.java", sourcePath = "c12/working_with_enums_fundamentals")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ValueOfValidUse")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Enums can be retrieved via the valueOf method
     * but if thew name is not identical to the enum's name
     * an IllegalArgumentException will be thrown
     */
    @Test
    @DisplayName("Invalid use of valueOf method")
    public void valueOfInvalidUse(
            @CompileClasses(classesToCompile = "ValueOfInvalidUse.java", sourcePath = "c12/working_with_enums_fundamentals")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ValueOfInvalidUse")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertNotEquals(0, outputExecution);
    }

    /**
     * Enums can also be used in switch statements
     */
    @Test
    @DisplayName("Valid use of enums in switch statement")
    public void enumsInSwitchStatement(
            @CompileClasses(classesToCompile = "EnumsInSwitchStatement.java", sourcePath = "c12/working_with_enums_fundamentals")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "EnumsInSwitchStatement")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
