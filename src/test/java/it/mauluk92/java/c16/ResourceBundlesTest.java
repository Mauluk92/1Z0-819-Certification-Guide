package it.mauluk92.java.c16;

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
 * This class contain tests to validate rules about using Resource Bundles
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class ResourceBundlesTest {

    /**
     * A resource bundle contains the locale-specific objects to be
     * used by a program. It is like a map with keys and values.
     * The resource bundle is commonly stored in a properties file.
     * A properties file is a text file in a specific format with key/value
     * pairs.
     */
    @Test
    @DisplayName("Using a resource bundle")
    public void usingResourceBundle(
            @CompileClasses(classesToCompile = "UsingResourceBundle.java", sourcePath = "c16/resource_bundles/using_resource_bundles")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "UsingResourceBundle", classPath = {"c16/resource_bundles/using_resource_bundles"})
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Often, we just want to output the text data
     * from a resource bundle, but sometimes you
     * want to format that data with parameters.
     * In real programs, it is common to substitute
     * variables in the middle of a resource bundle
     * string. The convention is to use a number inside
     * braces such as {0}, {1}
     */
    @Test
    @DisplayName("Formatting resource bundle string")
    public void formattingResourceBundleString(
            @CompileClasses(classesToCompile = "FormattingResourceBundleString.java", sourcePath = "c16/resource_bundles/formatting_resource_bundle_string")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "FormattingResourceBundleString", classPath = {"c16/resource_bundles/formatting_resource_bundle_string"})
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * When working with Resource bundle class, you may also
     * come across the Properties class. It functions like the HashMap
     * class except that it uses Strings for the keys and values.
     */
    @Test
    @DisplayName("Properties class")
    public void propertiesClass(
            @CompileClasses(classesToCompile = "PropertiesClass.java", sourcePath = "c16/resource_bundles")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "PropertiesClass")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
