package it.mauluk92.java.c2;

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
 * This class contains tests to validate rules regarding the scope of local variables
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class ManagingVariableScopeTest {

    /**
     * Variables declared at the top of a method (not in an enclosing smaller scope) or constructor
     * and method/constructor parameters have their scope that lasts until the end of the declaration
     */
    @Test
    @DisplayName("Method parameter and constructor parameter have a scope limited to the entire method/constructor.")
    public void scopeInsideAMethod(
            @CompileClasses(classesToCompile = "ScopeInsideAMethod.java", sourcePath = "c2/managing_variable_scope")
            Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Variables declared in an enclosing smaller scope cannot be accessed from outside and the compiler
     * will complain
     */
    @Test
    @DisplayName("Variables inside a smaller scope cannot be accessed outside their scope")
    public void smallerScopeAccess(
            @CompileClasses(classesToCompile = "SmallerScopeAccess.java", sourcePath = "c2/managing_variable_scope")
            Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Variables can access other variables outside their scope in the larger limiting and enclosing scope
     */
    @Test
    @DisplayName("Variables can access other variables from larger limiting scopes")
    public void largerScopeAccess(
            @CompileClasses(classesToCompile = "LargerScopeAccess.java", sourcePath = "c2/managing_variable_scope")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "LargerScopeAccess")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
