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
 * This class contain tests to validate rules about advanced pipelines concept in streams
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class AdvancedPipelineConceptsTest {

    /**
     * Optionals have a few of intermediate operations
     * available to streams, which can be used to obtain
     * a value
     */
    @Test
    @DisplayName("Chaining Optional")
    public void chainingOptional(
            @CompileClasses(classesToCompile = "ChainingOptional.java", sourcePath = "c15/advanced_pipeline_concepts")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ChainingOptional")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The collect() method can be used with predefined
     * collectors from the Collectors class, used
     * to group standard and reusable Collector strategies
     */
    @Test
    @DisplayName("Chaining Optional")
    public void collectorsClass(
            @CompileClasses(classesToCompile = "CollectorsClass.java", sourcePath = "c15/advanced_pipeline_concepts")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CollectorsClass")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The collect() method can be used to collect data
     * inside a map by specifying a function which generates a key
     * and the value, plus optionally an implementation of Map interface
     */
    @Test
    @DisplayName("Collect to map")
    public void collectToMap(
            @CompileClasses(classesToCompile = "CollectToMap.java", sourcePath = "c15/advanced_pipeline_concepts")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CollectToMap")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The collect() method can be used with Collectors.groupingBy.
     * The groupingBy tells collect that it should group all the elements
     * of the stream into a map. The function determines the keys in the map.
     * Each value in the map is a list of all entities that match the key.
     * We can even specify a third argument which provide a downstream
     * Collector and tells us what to do with the values inside the map
     */
    @Test
    @DisplayName("Collect with groupingBy")
    public void collectGroupingBy(
            @CompileClasses(classesToCompile = "CollectGroupingBy.java", sourcePath = "c15/advanced_pipeline_concepts")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CollectGroupingBy")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The collect() method can be used to partition data.
     * Partitioning is a special case of grouping with partitioning.
     * With partitioning there are only two alternatives - true and false.
     * We pass a predicate in order to group the elements.
     * We can even provide a downstream Collectors.
     */
    @Test
    @DisplayName("Collectors partitioning")
    public void collectPartitioningBy(
            @CompileClasses(classesToCompile = "CollectPartitioningBy.java", sourcePath = "c15/advanced_pipeline_concepts")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CollectPartitioningBy")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The collect() method can be used to provide a further
     * that lets us go down a level and add another collector.
     */
    @Test
    @DisplayName("Collect mapping")
    public void collectorMapping(
            @CompileClasses(classesToCompile = "CollectorMapping.java", sourcePath = "c15/advanced_pipeline_concepts")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CollectorMapping")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
