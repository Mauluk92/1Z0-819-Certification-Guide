package it.mauluk92.java.c9;

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
 * This class contains tests to validate rules about abstract classes and interfaces
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class CreatingAbstractClassesTest {

    /**
     * An abstract class is a class that cannot be instantiated
     * and marked with the abstract modifier
     */
    @Test
    @DisplayName("Abstract classes cannot be instantiated")
    public void cannotInstantiateAbstractClass(
            @CompileClasses(classesToCompile = "CannotInstantiateAbstractClass.java", sourcePath = "c9/creating_abstract_classes")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * An abstract class may contain abstract methods,
     * which must be overriden by the concrete subclass that
     * extends it
     */
    @Test
    @DisplayName("Abstract method must be overriden")
    public void abstractMethodMustBeOverriden(
            @CompileClasses(classesToCompile = "AbstractMethodMustBeOverriden.java", sourcePath = "c9/creating_abstract_classes")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * One of the most important features of an abstract class is that
     * it is not actually required to include any abstract methods
     */
    @Test
    @DisplayName("Abstract classes may not contain any abstract method")
    public void abstractClassWithoutAbstractMethods(
            @CompileClasses(classesToCompile = "AbstractClassWithoutAbstractMethods.java", sourcePath = "c9/creating_abstract_classes")
            Integer outputCompilation
    ){
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Abstract methods, on the other hands, cannot be defined in concrete
     * classes
     */
    @Test
    @DisplayName("Abstract methods cannot be defined in concrete classes")
    public void abstractMethodsConcreteClassesMustNotCompile(
            @CompileClasses(classesToCompile = "AbstractMethodsConcreteClassesMustNotCompile.java", sourcePath = "c9/creating_abstract_classes")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Abstract modifier cannot be put after the return type in a method
     */
    @Test
    @DisplayName("Abstract modifier cannot be put after the return type")
    public void invalidPositionAbstractMethodModifier(
            @CompileClasses(classesToCompile = "InvalidPositionAbstractMethodModifier.java", sourcePath = "c9/creating_abstract_classes")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Abstract class modifier must be put before the class declaration, not after
     */
    @Test
    @DisplayName("Abstract class modifier must be put before the class keyword")
    public void invalidPositionAbstractClassModifier(
            @CompileClasses(classesToCompile = "InvalidPositionAbstractClassModifier.java", sourcePath = "c9/creating_abstract_classes")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Constructors in abstract classes are allowed but will only be called
     * from a concrete subclass
     */
    @Test
    @DisplayName("Constructors in abstract classes are allowed")
    public void constructorsAbstractClasses(
            @CompileClasses(classesToCompile = "ConstructorsAbstractClasses.java", sourcePath = "c9/creating_abstract_classes")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ConstructorsAbstractClasses")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Abstract methods may not provide any implementation inside them or
     * a compile time error will occur
     */
    @Test
    @DisplayName("No implementation must be provided for an abstract method")
    public void noImplementationAbstractMethod(
            @CompileClasses(classesToCompile = "NoImplementationAbstractMethod.java", sourcePath = "c9/creating_abstract_classes")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Final modifier is incompatible with an abstract modifier
     * and will not compile
     */
    @Test
    @DisplayName("Incompatibility between final and abstract")
    public void incompatibilityFinalAbstractModifiers(
            @CompileClasses(classesToCompile = "IncompatibilityFinalAbstractModifiers.java", sourcePath = "c9/creating_abstract_classes")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Also, an abstract method cannot be declared private since
     * a private method, technically speaking, can only be redefined in child class
     * but not overridden
     */
    @Test
    @DisplayName("Incompatibility between private and abstract")
    public void incompatibilityPrivateAbstractModifiers(
            @CompileClasses(classesToCompile = "IncompatibilityPrivateAbstractModifiers.java", sourcePath = "c9/creating_abstract_classes")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Since, also, static methods cannot be overridden but only hidden, technically,
     * then it is illegal to define a static method as abstract
     */
    @Test
    @DisplayName("Incompatibility between static and abstract")
    public void incompatibilityStaticAbstract(
            @CompileClasses(classesToCompile = "IncompatibilityStaticAbstract.java", sourcePath = "c9/creating_abstract_classes")
            Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }
}
