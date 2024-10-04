package it.mauluk92.java.c4;

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
 * This class contains tests to validate rules regarding conditional flow execution (if/else and switch statements)
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class DecisionMakingStatementsTest {

    /**
     * This test ensures that if/else statements execute conditional logic on statements
     */
    @Test
    @DisplayName("If statements can execute selectively block of statements base on boolean expression")
    public void ifStatement(
            @CompileClasses(classesToCompile = "IfStatement.java", sourcePath = "c4/decision_making_statements")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "IfStatement")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Unreachable code in if statements
     */
    @Test
    @DisplayName("Certain conditions make statements reachable")
    public void unreachableBranch(
            @CompileClasses(classesToCompile = "UnreachableBranch.java", sourcePath = "c4/decision_making_statements")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "UnreachableBranch")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Switch statements can be used in place of if-else statements with multiple branches
     */
    @Test
    @DisplayName("Switch statements provide a convenient alternative to long if else statements")
    public void switchStatement(
            @CompileClasses(classesToCompile = "SwitchStatement.java", sourcePath = "c4/decision_making_statements")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "SwitchStatement")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Switch statements will only be allowed, short, byte, int, char, long, boolean, String and relative primitive Wrapper classes such
     * as Integer or Long and Enums
     */
    @Test
    @DisplayName("Only primitive data types and wrappers, together with String objects and Enums, are supported in switch statements")
    public void notAllowedDataTypesSwitch(
            @CompileClasses(classesToCompile = "NotAllowedDataTypesSwitch.java", sourcePath = "c4/decision_making_statements")
            Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Switch control flow may be altered by the use of break statements
     */
    @Test
    @DisplayName("Without break statements, case statements blocks are executed in their respective natural order")
    public void switchFlow(
            @CompileClasses(classesToCompile = "SwitchFlow.java", sourcePath = "c4/decision_making_statements")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "SwitchFlow")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Only certain values are acceptable in case statements: constant expressions
     */
    @Test
    @DisplayName("Allowed case values are only those that are final, known at compile time. Any other value will not compile, such as an expression")
    public void allowedCaseValues(
            @CompileClasses(classesToCompile = "AllowedCaseValues1.java", sourcePath = "c4/decision_making_statements")
            Integer outputCompilationFirst,
            @CompileClasses(classesToCompile = "AllowedCaseValues2.java", sourcePath = "c4/decision_making_statements")
            Integer outputCompilationSecond
    ) {
        Assertions.assertNotEquals(0, outputCompilationFirst);
        Assertions.assertNotEquals(0, outputCompilationSecond);
    }


}
