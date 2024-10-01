package it.mauluk92.java.c2;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contains tests to validate the rule for variable declaration and identifiers
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class DeclaringVariablesTest {

    /**
     * A valid identifier must start with a letter, $ or _ (underscore)
     * Can include numbers but not at the start of the identifier itself.
     */
    @Test
    @DisplayName("Identifiers must follow certain rules")
    public void validIdentifiers(
            @CompileClasses(classesToCompile = "ValidIdentifiers.java", sourcePath = "c2/declaring_variables")
            Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * If an illegal combination of identifier is used, the file do not compile
     */
    @Test
    @DisplayName("Invalid identifiers must not compile")
    public void invalidIdentifiers(
            @CompileClasses(classesToCompile = "InvalidIdentifiers1.java", sourcePath = "c2/declaring_variables")
            Integer outputCompilationFirst,
            @CompileClasses(classesToCompile = "InvalidIdentifiers2.java", sourcePath = "c2/declaring_variables")
            Integer outputCompilationSecond,
            @CompileClasses(classesToCompile = "InvalidIdentifiers3.java", sourcePath = "c2/declaring_variables")
            Integer outputCompilationThird
    ) {
        Assertions.assertNotEquals(0, outputCompilationFirst);
        Assertions.assertNotEquals(0, outputCompilationSecond);
        Assertions.assertNotEquals(0, outputCompilationThird);
    }

    /**
     * In Java, we can declare multiple variables at once with a specific syntax
     */
    @Test
    @DisplayName("Multiple declaration can be made simultaneously")
    public void validMultipleDeclarations(
            @CompileClasses(classesToCompile = "ValidMultipleDeclarations.java", sourcePath = "c2/declaring_variables")
            Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * It is illegal to define more than one type, more than once, in a multiple declaration statement
     */
    @Test
    @DisplayName("Multiple declarations must have the same type and the type has to be declared once")
    public void invalidMultipleDeclarations(
            @CompileClasses(classesToCompile = "InvalidMultipleDeclarations.java", sourcePath = "c2/declaring_variables")
            Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
