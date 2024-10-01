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
 * This test class validates the rules regarding literals and primitive data types
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UnderstandingDataTypesTest {

    /**
     * This test ensures that primitive data types needs specific literal in order
     * to be initialized correctly
     */
    @Test
    @DisplayName("Certain primitive data types will be assigned only with the corresponding literal")
    public void literalPrimitiveDataType(
            @CompileClasses(classesToCompile = "LiteralPrimitiveDataType.java", sourcePath = "c2/understanding_data_types")
            Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }
    /**
     * In general, an underscore inside a numeric literal can be anywhere except at the start
     * at the end, around a decimal period. However, multiple underscore literals are allowed, of any length
     */
    @Test
    @DisplayName("There are numeric literal with underscore which have to respect certain rules")
    public void numericLiteralsWithUnderscore(
            @CompileClasses(classesToCompile = "NumericLiteralsWithUnderscore.java", sourcePath = "c2/understanding_data_types")
            Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }
    /**
     * Primitive data types are different from reference types. While the latter can be assigned null, to indicate
     * an absence of value, primitives do not represent an object and cannot therefore be assigned a null value
     */
    @Test
    @DisplayName("A primitive data type cannot be assigned a null value, because they do not represents objects")
    public void primitivesCannotBeAssignedNull(
            @CompileClasses(classesToCompile = "PrimitivesCannotBeAssignedNull.java", sourcePath = "c2/understanding_data_types")
            Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
