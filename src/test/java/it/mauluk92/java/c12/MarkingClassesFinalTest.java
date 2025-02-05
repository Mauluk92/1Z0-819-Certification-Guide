package it.mauluk92.java.c12;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contain tests to validate rules about final classes
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class MarkingClassesFinalTest {

    /**
     * Final classes cannot be extended by other classes
     */
    @Test
    @DisplayName("Final classes cannot be extended")
    public void finalClassesCannotBeExtended(
            @CompileClasses(classesToCompile = "FinalClassesCannotBeExtended.java", sourcePath = "c12/marking_classes_final")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Interfaces cannot be marked as final since they are abstract
     */
    @Test
    @DisplayName("Interfaces cannot be marked as final")
    public void interfacesCannotBeMarkedAsFinal(
            @CompileClasses(classesToCompile = "InterfacesCannotBeMarkedAsFinal.java", sourcePath = "c12/marking_classes_final")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }


}
