package it.mauluk92.java.c16;

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
 * This class contain tests to validate rules about declaring assertions
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class DeclaringAssertionsTest {

    /**
     * When assertions are enabled and the boolean evaluates to false,
     * then an AssertionError will be thrown at runtime since programs
     * aren't supposed to catch an error, this means that assertion failures
     * are fatal and end the program. They may include optional
     * parentheses and a message
     */
    @Test
    @DisplayName("Structure of assertions")
    public void structureAssertions(
            @CompileClasses(classesToCompile = "StructureAssertions.java", sourcePath = "c16/declaring_assertions")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "StructureAssertions")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertNotEquals(0, outputExecution);
    }

    /**
     * Assertions should never alter outcomes.
     * This is especially true because assertions, can
     * and should, and probably will be turned off in a production
     * environment
     */
    @Test
    @DisplayName("Assertions should not alter outcomes")
    public void assertionGoodPractice(
            @CompileClasses(classesToCompile = "AssertionGoodPractice.java", sourcePath = "c16/declaring_assertions")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }
}
