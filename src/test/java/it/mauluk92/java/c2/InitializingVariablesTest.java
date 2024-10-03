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
 * This class contains rules to validate the initialization of variables in Java 11
 * with var (local type inference), default initialization for non-local variables and
 * multiple variable initialization
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class InitializingVariablesTest {

    /**
     * The compiler will complain if a local variable is uninitialized and is used inside the code.
     * There is no default value for local variables.
     */
    @Test
    @DisplayName("Uninitialized local variables won't compile")
    public void uninitializedLocalVariable(
            @CompileClasses(classesToCompile = "UninitializedLocalVariable.java", sourcePath = "c2/initializing_variables")
            Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * If a local variable is left uninitialized inside a branch in a conditional statement,
     * and that variables is used later inside the program, the compiler will complain
     */
    @Test
    @DisplayName("The same holds for complex initialization, such as local initialization on conditional branches")
    public void conditionalUninitializedLocalVariable(
            @CompileClasses(classesToCompile = "ConditionalUninitializedLocalVariable.java", sourcePath = "c2/initializing_variables")
            Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * For the purpose of validation by the compiler, an uninitialized variable cannot be passed
     * as method or constructor parameter
     */
    @Test
    @DisplayName("The very same rules apply for constructor and method parameters: they are considered pre-initialized local variables")
    public void passingUninitializedArgumentMethod(
            @CompileClasses(classesToCompile = "PassingUninitializedArgumentMethod.java", sourcePath = "c2/initializing_variables")
            Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }
    /**
     * All instances variables and class variables can be used even when left uninitialized
     * because they do have a default value
     */
    @Test
    @DisplayName("The same does not hold for class and instance variables: they have a default value")
    public void defaultValuesClassInstanceVariables(
            @CompileClasses(classesToCompile = "DefaultValuesInstanceVariables.java", sourcePath = "c2/initializing_variables")
            Integer outputCompilationInstanceVariables,
            @ExecuteJavaProgram(mainClass = "DefaultValuesInstanceVariables")
            Integer outputExecutionInstanceVariables,
            @CompileClasses(classesToCompile = "DefaultValuesClassVariables.java", sourcePath = "c2/initializing_variables")
            Integer outputCompilationClassVariables,
            @ExecuteJavaProgram(mainClass = "DefaultValuesClassVariables")
            Integer outputExecutionClassVariables
    ) {
        Assertions.assertEquals(0, outputCompilationInstanceVariables);
        Assertions.assertEquals(0, outputExecutionInstanceVariables);
        Assertions.assertEquals(0, outputCompilationClassVariables);
        Assertions.assertEquals(0, outputExecutionClassVariables);

    }
    /**
     * Var can be used to infer the type of local variable, but has to be initialized on the same statement
     */
    @Test
    @DisplayName("var keyword can be used to make an inline declaration and initialization without specifying the type")
    public void localVariableTypeInference(
            @CompileClasses(classesToCompile = "LocalVariableTypeInference.java", sourcePath = "c2/initializing_variables")
            Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }
    /**
     * As the name suggest, var cannot be used in instance variables and neither can be used
     * on method parameter to infer the type of the parameter itself, since those variables
     * have to be initialized before their use inside a method
     */
    @Test
    @DisplayName("Cannot use var in an instance variable or inside a method declaration")
    public void varInInstanceVariablesMustNotCompile(
            @CompileClasses(classesToCompile = "VarInInstanceVariablesMustNotCompile.java", sourcePath = "c2/initializing_variables")
            Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }
    /**
     * var cannot be used unless the declaration is followed by initialization, and the object is not null
     * Also, var is not allowed in multiple variable declaration and cannot be initialized in another line.
     * Declaration and initialization must occur at the same time.
     */
    @Test
    @DisplayName("There are certain rules for the use of var for local type inference")
    public void varRules(
            @CompileClasses(classesToCompile = "VarRulesNotInitialized.java", sourcePath = "c2/initializing_variables")
            Integer outputCompilationNotInitialized,
            @CompileClasses(classesToCompile = "VarRulesNullReference.java", sourcePath = "c2/initializing_variables")
            Integer outputCompilationNull,
            @CompileClasses(classesToCompile = "VarRulesMultipleDeclaration.java", sourcePath = "c2/initializing_variables")
            Integer outputCompilationMultipleDeclaration
    ) {
        Assertions.assertNotEquals(0, outputCompilationNotInitialized);
        Assertions.assertNotEquals(0, outputCompilationNull);
        Assertions.assertNotEquals(0, outputCompilationMultipleDeclaration);
    }

    /**
     * Var is a reserved type word but not a reserved keyword. As such, can be used inside an identifier, but not as a name
     * of a type (a class)
     */

    @Test
    @DisplayName("var is a type reserved word. This means it can be used as an identifier of methods and variables, but not of types")
    public void varReservedTypeWord(
            @CompileClasses(classesToCompile = "VarReservedTypeWord.java", sourcePath = "c2/initializing_variables")
            Integer outputCompilationReservedTypeWord,
            @CompileClasses(classesToCompile = "VarNotAReservedWord.java", sourcePath = "c2/initializing_variables")
            Integer outputCompilationNotAReservedWord
    ) {
        Assertions.assertNotEquals(0, outputCompilationReservedTypeWord);
        Assertions.assertEquals(0, outputCompilationNotAReservedWord);
    }
    /**
     * Null is allowed as an assignment to a var variable only if an explicit cast is used to allow
     * the compiler to infer the type anyway
     */

    @Test
    @DisplayName("var can be assigned null, only if it is specified the type through an explicit cast")
    public void nullCanBeAssignedWithCast(
            @CompileClasses(classesToCompile = "NullReferenceAllowedWithVar.java", sourcePath = "c2/initializing_variables")
            Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }
}
