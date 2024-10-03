package it.mauluk92.java.c3;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contains test to validate rules regarding the assignment operator, which returns a value
 * equal to the value assigned
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class AssignmentOperatorTest {

    /**
     * Assignment operator is effectively an expression which returns a value
     */
    @Test
    @DisplayName("Assignment operator returns the value assigned as a result")
    public void assignmentOperatorValue(
            @CompileClasses(classesToCompile = "AssignmentOperatorValue.java", sourcePath = "c3/assignment_operator")
            Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
