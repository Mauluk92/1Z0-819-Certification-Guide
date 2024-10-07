package it.mauluk92.java.c6;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class WorkingWithVariablesInLambdasTest {

    /**
     * Even if lambdas can access variables outside their scope, there are strict rules about
     * what counts as a legal reference inside a lambda
     */
    @Test
    @DisplayName("Lambdas can access variables outside their scope")
    public void rulesVariablesLambda(
            @CompileClasses(classesToCompile = "RulesVariablesLambda.java", sourcePath = "c6/working_with_variables_in_lambdas")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
