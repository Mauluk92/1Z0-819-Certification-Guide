package it.mauluk92.java.c19;

import java.io.*;
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
 * This class contain tests to validate rules about Serializing Data
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class SerializingDataTest {

    /**
     * You can use the I/O stream classes you've learned about
     * so for to store text and binary data, but you still have
     * to figure out how to put data in the stream and then decode it
     * later. Luckily, you can use serialization to solve this
     * problem of how to convert objects to/from a stream.
     * <em>Serialization</em> is the process of converting an
     * in memory object to a byte stream. Likewise, deserialization is
     * the process of converting from a byte stream into an object.
     * Serialization often involves writing an object to a stored or
     * transmittable format, while deserialization is the reciprocal
     * process. To serialize an object using the I/O API,
     * the object must implement the {@link Serializable} interface.
     * It is a marker interface which therefore does not have any marker
     * interface. Any class can implements Serializable since there are no
     * required method to override.
     * The purpose of using the serializable interface is to inform any process
     * attempting to serialize the objects that you have taken the proper steps
     * to make the object serializable.
     */
    @Test
    @DisplayName("Applying the serializable interface")
    public void applyingSerializableInterface(
            @CompileClasses(classesToCompile = "ApplyingSerializableInterface.java", sourcePath = "c19/serializing_data")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ApplyingSerializableInterface")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The <em>transient</em> modifier is used for sensitive data of
     * the class, like a password. There are other objects that does not
     * make sense to serialize, like the state of an in memory thread. If the
     * object is part of a serializable object, we just mark it transient
     * to ignore these instance members. What happens to data marked transient during
     * deserialization? It reverts to its default Java values, or null for objects.
     */
    @Test
    @DisplayName("The transient modifier")
    public void transientModifier(
            @CompileClasses(classesToCompile = "TransientModifier.java", sourcePath = "c19/serializing_data")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "TransientModifier")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Any process attempting to serialize an object will throw a {@link NotSerializableException}
     * if the class does not implement the {@link Serializable} interface properly.
     * Also, every field of the class must be either serializable, transient or null at the
     * time of serialization. Otherwise, an exception will be thrown
     */
    @Test
    @DisplayName("Rules serializable objects")
    public void rulesSerializableObjects(
            @CompileClasses(classesToCompile = "RulesSerializableObjects.java", sourcePath = "c19/serializing_data")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "RulesSerializableObjects")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertNotEquals(0, outputExecution);
    }


    /**
     * When you deserialize an object, <em>the constructor of the serialized
     * class, along with any instance initializers, is not called when the object
     * is created</em>. Java will the no-arg constructor of the first
     * non-serializable parent class it can find in the class hierarchy.
     * Also, any static or transient fields are ignored. Values not provided
     * will be given their default Java value, such as null for String or 0
     * for int values.
     */
    @Test
    @DisplayName("Deserialization process")
    public void deserializationProcess(
            @CompileClasses(classesToCompile = "DeserializationProcess.java", sourcePath = "c19/serializing_data")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "DeserializationProcess")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
