package it.mauluk92.java.c7;

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
 * This class validates rules about the static keyword as applied to members
 * fields and classes
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class ApplyingStaticKeywordTest {

    /**
     * It is possible to access static variable from an instance variable
     * In general, that means the instance could be null and it will compile nonetheless
     */
    @Test
    @DisplayName("Instance variables can access static variables")
    public void staticVariablesFromInstance(
            @CompileClasses(classesToCompile = "StaticVariablesFromInstance.java", sourcePath = "c7/applying_static_keyword")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "StaticVariablesFromInstance")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The converse is not true since a static method cannot call an instance variable
     * without referencing before an instance of that class
     */
    @Test
    @DisplayName("Static member cannot call an instance variable without referencing an instance of the class")
    public void instanceMemberFromStaticMember(
            @CompileClasses(classesToCompile = "InstanceMemberFromStaticMember.java", sourcePath = "c7/applying_static_keyword")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }


    /**
     * Static block initializers provide a way to initialize static members of a class
     */
    @Test
    @DisplayName("Static initialization can be used as an alternative means to initialize static members")
    public void staticInitialization(
            @CompileClasses(classesToCompile = "StaticInitialization.java", sourcePath = "c7/applying_static_keyword")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "StaticInitialization")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Static imports provides a convenient way to import static members inside a code application
     */

    @Test
    @DisplayName("Static imports can be used as a means to import static member of a class, such as class")
    public void staticImport(
            @CompileClasses(classesToCompile = {"package_a/ClassPackageA.java", "package_b/ClassPackageB.java"}, sourcePath = "c7/applying_static_keyword/static_import")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "package_b.ClassPackageB")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
