package it.mauluk92.java.c15;

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
 * This class contain tests to validate rules about common functional interfaces
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class CommonFunctionalInterfacesTest {

    /**
     * A supplier is used when you want to generate or supply
     * values without taking any input.
     * The supplier interface include one method, get
     */
    @Test
    @DisplayName("Supplier interface")
    public void supplierInterface(
            @CompileClasses(classesToCompile = "SupplierInterface.java", sourcePath = "c15/common_functional_interfaces")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "SupplierInterface")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * A consumer is used whenever you want to do something with a parameter
     * but not return anything. BiConsumer does the same thing except that it takes
     * two parameters.
     */
    @Test
    @DisplayName("Consumer interface")
    public void consumerInterface(
            @CompileClasses(classesToCompile = "ConsumerInterface.java", sourcePath = "c15/common_functional_interfaces")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ConsumerInterface")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * A predicate is used to test a condition whenever we want
     * to filter or match data. BiPredicate accepts two arguments
     * and does basically the same thing.
     */
    @Test
    @DisplayName("Predicate interface")
    public void predicateInterface(
            @CompileClasses(classesToCompile = "PredicateInterface.java", sourcePath = "c15/common_functional_interfaces")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "PredicateInterface")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * A function is responsible for turning one parameter
     * into a value of a potentially different type and returning
     * it. Similarly, a BiFunction is responsible for turning two parameters
     * into a value and returning it.
     */
    @Test
    @DisplayName("Function interface")
    public void functionInterface(
            @CompileClasses(classesToCompile = "FunctionInterface.java", sourcePath = "c15/common_functional_interfaces")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "FunctionInterface")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * UnaryOperator and BinaryOperator are a special case of function.
     * They require all type parameters to be the same type. A Unary operator transforms its value
     * into another one of the same type. A binary merges two values into one
     * of the same type.
     */
    @Test
    @DisplayName("Operator interface")
    public void operatorInterface(
            @CompileClasses(classesToCompile = "OperatorInterface.java", sourcePath = "c15/common_functional_interfaces")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "OperatorInterface")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * By definition, all functional interfaces have a single abstract method.
     * This doesn't mean they can have only one method, though.
     * Several of the common functional interfaces provide a number of
     * helpful default methods.
     */
    @Test
    @DisplayName("Default methods functional interface")
    public void convenienceMethods(
            @CompileClasses(classesToCompile = "ConvenienceMethods.java", sourcePath = "c15/common_functional_interfaces")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ConvenienceMethods")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
