package it.mauluk92.java.c8;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contains tests to validate rule about inheritance of methods and variables (overriding and hiding)
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class InheritingMembersTest {

    /**
     * Method in the child class must have the same signature as the method
     * in the parent class during overriding
     */
    @Test
    @DisplayName("Rule of same signature in overriding")
    public void sameSignatureRuleOverriding(
            @CompileClasses(classesToCompile = "SameSignatureRuleOverriding.java", sourcePath = "c8/inheriting_members")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Method in the child class must be at least as accessible as the method
     * in the parent class during overriding
     */
    @Test
    @DisplayName("Rule of accessibility in overriding")
    public void accessibilityRuleOverriding(
            @CompileClasses(classesToCompile = "AccessibilityRuleOverriding.java", sourcePath = "c8/inheriting_members")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
