package it.mauluk92.java.c7;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class WorkingWithVarArgsTest {

    /**
     * Varargs allow to make possible to define multiple arguments on parameters list
     */
    @Test
    @DisplayName("VarArgs must be at the end of the parameter list")
    public void varArgsMustBeLast(
            @CompileClasses(classesToCompile = "VarArgsMustBeLast.java", sourcePath = "c7/working_with_varargs")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
