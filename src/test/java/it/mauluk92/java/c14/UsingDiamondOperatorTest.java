package it.mauluk92.java.c14;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contain tests to validate rules about using diamond operator
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UsingDiamondOperatorTest {

    /**
     * Diamond operator is a shorthand notation
     * used with generic declarations
     */
    @Test
    @DisplayName("Diamond operator correct usage")
    public void diamondOperatorCorrectUsage(
            @CompileClasses(classesToCompile = "DiamondOperatorCorrectUsage.java", sourcePath = "c14/using_diamond_operator")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Diamond operator cannot be used if the parametrized type cannot
     * be inferred during declaration (on the left side)
     */
    @Test
    @DisplayName("Diamond operator incorrect usage")
    public void diamondOperatorIncorrectUsage(
            @CompileClasses(classesToCompile = "DiamondOperatorIncorrectUsage.java", sourcePath = "c14/using_diamond_operator")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
