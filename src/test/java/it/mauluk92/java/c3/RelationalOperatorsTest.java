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
 * This class validates the rules regarding relational operators in Java (instanceof as an example)
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class RelationalOperatorsTest {

    /**
     * Relational operator instanceof can be applied to a null object, as its first argument, but gives away
     * an error at compilation when used to confront any objects to null (compiler can't infer the type of null reference)
     */
    @Test
    @DisplayName("instanceof cannot be used to confront any objects to null, though it accepts null as first argument")
    public void instanceOfNull(
            @CompileClasses(classesToCompile = "InstanceOfNull.java", sourcePath = "c3/relational_operators")
            Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
