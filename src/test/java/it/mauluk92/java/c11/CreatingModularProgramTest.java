package it.mauluk92.java.c11;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import it.mauluk92.java.testutils.extension.annotation.ExecuteJavaProgram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class CreatingModularProgramTest {

    @Test
    public void testModule(
            @CompileClasses(classesToCompile = {
                    "internal/module-info.java",
                    "internal/nested/deep/InternalNestedDeepFile.java"
            }, sourcePath = "c11/creating_modular_program")
            Integer outputCompilation,
            @ExecuteJavaProgram(moduleName = "internal.nested.deep/internal.nested.deep.InternalNestedDeepFile")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
