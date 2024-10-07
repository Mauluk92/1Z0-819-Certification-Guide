package it.mauluk92.java.c6;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import it.mauluk92.java.testutils.extension.annotation.ExecuteJavaProgram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contains test to validate rules about functional interfaces and lambdas
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class FunctionalInterfacesTest {

    /**
     * Functional Interfaces contain SAM and there are in Java different type of those interfaces
     * out of the box, such as Predicate and Supplier
     */
    @Test
    @DisplayName("Functional interfaces contain SAM (Single Abstract Method)")
    public void introducingFunctionalInterfaces(
            @CompileClasses(classesToCompile = "IntroducingFunctionalInterfaces.java", sourcePath = "c6/functional_interfaces")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "IntroducingFunctionalInterfaces") Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }


    /**
     * You can use lambdas everywhere there is a SAM interface, with a single abstract method
     */
    @Test
    @DisplayName("Lambdas are like methods without name that you can carry around the code")
    public void writingALambda(
            @CompileClasses(classesToCompile = "WritingALambda.java", sourcePath = "c6/functional_interfaces")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "WritingALambda") Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
