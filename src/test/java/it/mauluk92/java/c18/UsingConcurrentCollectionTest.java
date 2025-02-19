package it.mauluk92.java.c18;

import java.util.ConcurrentModificationException;
import java.util.concurrent.*;
import java.util.*;
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
 * This class contain tests to validate rules about concurrent Collection API
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class UsingConcurrentCollectionTest {

    /**
     * Besides managing threads, the concurrency API includes
     * interfaces and classes that help you coordinate access
     * to collections shared by multiple tasks. The purpose
     * of the concurrent collection classes is to solve
     * common memory consistency errors. A memory consistency error
     * occurs when two threads have inconsistent views of what should be
     * the same data. Conceptually, we want writes on one thread
     * to be available to another thread if it accesses the concurrent collection
     * after the write operation has occurred.
     * When two threads try to modify the same non-concurrent collection, the JVM
     * may a throw a {@link ConcurrentModificationException} at runtime.
     * It can also happen within a single thread!
     */
    @Test
    @DisplayName("Non Concurrent Collection improper usage")
    public void nonConcurrentCollection(
            @CompileClasses(classesToCompile = "NonConcurrentCollection.java", sourcePath = "c18/using_concurrent_collection")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "NonConcurrentCollection")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertNotEquals(0, outputExecution);
    }

    /**
     * Using a concurrent collection will prevent the JVM
     * to throw a {@link ConcurrentModificationException} at runtime
     * in the same circumstances
     */
    @Test
    @DisplayName("Concurrent Collection usage")
    public void concurrentCollectionUsage(
            @CompileClasses(classesToCompile = "ConcurrentCollectionUsage.java", sourcePath = "c18/using_concurrent_collection")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ConcurrentCollectionUsage")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * You should use a concurrent Collection class
     * anytime that you are going to have multiple threads modify a Collection
     * object outside a synchronized block or method, even if you
     * don't expect a concurrency problem. On the other hand, immutable or
     * read-only objects can be accessed by any number of threads
     * without a concurrency collection
     */
    @Test
    @DisplayName("Concurrent collection classes")
    public void concurrencyCollectionClasses(
            @CompileClasses(classesToCompile = "ConcurrencyCollectionClasses.java", sourcePath = "c18/using_concurrent_collection")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ConcurrencyCollectionClasses")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The SkipList classes, {@link ConcurrentSkipListMap} and {@link ConcurrentSkipListSet}
     * are concurrent versions of their sorted counterparts, {@link TreeSet} and
     * {@link TreeMap}. They maintain their elements or keys in the natural ordering
     * of their elements.
     */
    @Test
    @DisplayName("SkipList classes")
    public void skipListClasses(
            @CompileClasses(classesToCompile = "SkipListClasses.java", sourcePath = "c18/using_concurrent_collection")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "SkipListClasses")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * {@link CopyOnWriteArraySet} and {@link CopyOnWriteArrayList}, that behave a little
     * differently than the other concurrent classes that you have seen.
     * These classes copy all of their elements to a new underlying
     * structure anytime an element is added, modified or removed
     * from the collection. By a modified element, we mean that
     * the reference in the collections is changed.
     * Modifying the actual contents of objects within the collection
     * will not cause a new structure to be allocated.
     * Although the data is copied to a new underlying structure, our reference to
     * the Collection object does not change. This is particularly useful in
     * multi-threaded environments that need to iterate collections.
     * Any iterator established prior to modification, will not see that changes,
     * but instead will iterate over the original
     */
    @Test
    @DisplayName("CopyOnWrite classes")
    public void copyOnWriteClasses(
            @CompileClasses(classesToCompile = "CopyOnWriteClasses.java", sourcePath = "c18/using_concurrent_collection")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CopyOnWriteClasses")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * We have also {@link LinkedBlockingQueue} which implements
     * the {@link BlockingQueue} interface. It is just a regular queue,
     * except that includes methods to complete an operation within a certain
     * timeframe.
     */
    @Test
    @DisplayName("BlockingQueue classes")
    public void blockingQueueClasses(
            @CompileClasses(classesToCompile = "BlockingQueueClasses.java", sourcePath = "c18/using_concurrent_collection")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "BlockingQueueClasses")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Besides the concurrent collection classes that we have covered,
     * the Concurrency API also includes methods for obtaining synchronized
     * versions of existing non-concurrent collection objects. These synchronized
     * methods are defined in the {@link Collections} class. They operate
     * on the inputted collection and return a reference that is the same type
     * as the underlying collection
     */
    @Test
    @DisplayName("Synchronized Collection classes")
    public void synchronizedCollectionClasses(
            @CompileClasses(classesToCompile = "SynchronizedCollectionClasses.java", sourcePath = "c18/using_concurrent_collection")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "SynchronizedCollectionClasses")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertNotEquals(0, outputExecution);
    }
}
