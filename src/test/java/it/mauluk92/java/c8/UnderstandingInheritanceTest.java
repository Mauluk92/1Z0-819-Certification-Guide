package it.mauluk92.java.c8;

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
 * This class contains tests to validate rules about inheritance
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UnderstandingInheritanceTest {

    /**
     * Java supports single inheritance, by which a class may inherit from only a particular
     * direct parent class and multiple levels of inheritance nested deep as needed.
     * Each class may have only one parent class and Java disallow completely
     * multiple inheritance because of the complexities that may arise in data-models
     */
    @Test
    @DisplayName("Java supports only single inheritance mechanism")
    public void singleInheritance(@CompileClasses(classesToCompile = "SingleInheritance.java", sourcePath = "c8/understanding_inheritance")
                                      Integer outputCompilation,
                                  @ExecuteJavaProgram(mainClass = "SingleInheritance")
                                      Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
    /**
     * In Java, all classes inherit from a single class: java.lang.Object or Object for short.
     * But mostly, none of them do because every class that do not extend explicitly a direct parent class,
     * inherits from Object. We get all methods from this parent class by default such as
     * the toString() and equals() methods
     */
    @Test
    @DisplayName("Every class extends from Object class")
    public void everyClassIsObject(@CompileClasses(classesToCompile = "EveryClassIsObject.java", sourcePath = "c8/understanding_inheritance")
                                       Integer outputCompilation,
                                   @ExecuteJavaProgram(mainClass = "EveryClassIsObject")
                                       Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
