package it.mauluk92.java.c2;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import it.mauluk92.java.testutils.extension.annotation.ExecuteJavaProgram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class DestroyingObjectsTest {
    /**
     * Garbage collection acts automatically and cannot be predicted when it will happen
     */
    @Test
    @DisplayName("Tracing eligibility for garbage collection means that we are looking out when the object is no longer reachable by the program")
    public void tracingEligibilityForGarbageCollection(
            @CompileClasses(classesToCompile = "TracingEligibilityForGarbageCollection.java", sourcePath = "c2/destroying_objects")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "TracingEligibilityForGarbageCollection")
            Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
