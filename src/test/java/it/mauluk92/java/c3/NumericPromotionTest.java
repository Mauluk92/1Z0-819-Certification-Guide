package it.mauluk92.java.c3;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class NumericPromotionTest {


    /**
     * If two numbers have different data type, java will automatically promote one of the values to the larger of the two
     * data types
     */
    @Test
    @DisplayName("Int is automatically converted to long if it is in an operation with a long")
    public void numericPromotionFirstLaw(
            @CompileClasses(classesToCompile = "NumericPromotionFirstLaw.java", sourcePath = "c3/numeric_promotion")
            Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * If any of the two number is integral and the other is floating point (either float or double)
     * Java will automatically promote the integral value to the float data type
     */
    @Test
    @DisplayName("If one is a float data type and the other is integral, the result will be the float data type")
    public void numericPromotionSecondLaw(
            @CompileClasses(classesToCompile = "NumericPromotionSecondLaw.java", sourcePath = "c3/numeric_promotion")
            Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Smaller data types, such as bytes, short, char are first promoted to an int any time they're used in
     * binary arithmetic operators, even if neither isn't an integer
     */
    @Test
    @DisplayName("Smaller data types are converted to int in a binary arithmetic operation")
    public void numericPromotionThirdLaw(
            @CompileClasses(classesToCompile = "NumericPromotionThirdLaw.java", sourcePath = "c3/numeric_promotion")
            Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
