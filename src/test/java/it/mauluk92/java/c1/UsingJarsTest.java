package it.mauluk92.java.c1;

import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import it.mauluk92.java.testutils.extension.annotation.ExecuteJavaProgram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contains tests to validate the use of
 * jar files inside other programs
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UsingJarsTest {
    /**
     * This test ensures that a jar can be used in the classpath of compilation
     * of another class as external library
     */
    @Test
    @DisplayName("Jars can be used in the classpath as library for other code")
    public void creatingJarFile(
            @CompileClasses(
                    classesToCompile = "CreatingJarFile.java",
                    sourcePath = "c1/using_jars/creating_jar_file",
                    classPath = "c1/using_jars/creating_jar_file/jar_file/Library.jar"

            )
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CreatingJarFile", classPath = "c1/using_jars/creating_jar_file/jar_file/Library.jar")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
