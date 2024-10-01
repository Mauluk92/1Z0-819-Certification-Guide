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
 * This class contains tests that validates the rules for
 * logical groupings of classes under package and import statements
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class CreatingPackagesTest {
    /**
     * This test ensures that grouping classes under packages
     * and compiling them correctly, provides a logical grouping of classes
     * which can be accessed by other classes with import statements
     */
    @Test
    @DisplayName("Classes can be grouped under packages with a package statement")
    public void groupingUnderPackages(
            @CompileClasses(
                    classesToCompile = {"packagea/ClassPackageA.java", "packageb/ClassPackageB.java"},
                    sourcePath = "c1/creating_packages/grouping_under_packages")
            Integer outputCompilation,

            @ExecuteJavaProgram(mainClass = "packageb.ClassPackageB")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);

    }
}
