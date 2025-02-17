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
 * This class contain tests to validate rules about Java support for localization
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class SupportingLocalizationTest {

    /**
     * The Locale class is in the java.util package. The first
     * useful Locale is to find the user's current locale.
     * First comes the lowercase language code (en).
     * The language code is always required. Then comes
     * an underscore followed by the uppercase country code
     * (en_US). The country code is optional
     */
    @Test
    @DisplayName("User default Locale")
    public void userDefaultLocale(
            @CompileClasses(classesToCompile = "UserDefaultLocale.java", sourcePath = "c16/support_localization")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "UserDefaultLocale")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * As a developer, you often need to write code that
     * selects a locale other than the default one.
     * You can use builtin constants in the Locale class
     * to choose from common locales
     */
    @Test
    @DisplayName("Picking a common Locale from constants")
    public void constantsLocale(
            @CompileClasses(classesToCompile = "ConstantsLocale.java", sourcePath = "c16/support_localization")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ConstantsLocale")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }


    /**
     * The second way of selecting A Locale is to use the constructor
     * to create a new Locale. You can pass just a language, or
     * both a language and country
     */
    @Test
    @DisplayName("Creating a custom Locale")
    public void creatingCustomLocale(
            @CompileClasses(classesToCompile = "CreatingCustomLocale.java", sourcePath = "c16/support_localization")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "CreatingCustomLocale")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The third way to create a Locale that's more flexible.
     * The builder design pattern lets you set all of these properties
     * that you care about and then build it at the end. This means you
     * can specify the properties in any order
     */
    @Test
    @DisplayName("Builder Locale")
    public void builderLocale(
            @CompileClasses(classesToCompile = "BuilderLocale.java", sourcePath = "c16/support_localization")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "BuilderLocale")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }


    /**
     * When testing a program, you might need to use a Locale
     * other than the default of your computer
     */
    @Test
    @DisplayName("Setting the default")
    public void settingDefaultLocale(
            @CompileClasses(classesToCompile = "SettingDefaultLocale.java", sourcePath = "c16/support_localization")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "SettingDefaultLocale")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * When we format data, we convert it from a structured object,
     * or primitive values into a String.
     * The NumberFormat.format() method with the NumberFormat object
     */
    @Test
    @DisplayName("Formatting numbers")
    public void formattingNumbers(
            @CompileClasses(classesToCompile = "FormattingNumbers.java", sourcePath = "c16/support_localization")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "FormattingNumbers")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * When we parse data, we convert it from String
     * to a structured object or a primitive value.
     * The NumberFormat.parse() method accomplishes this
     * and takes the locale into consideration
     */
    @Test
    @DisplayName("Parsing numbers")
    public void parsingNumbers(
            @CompileClasses(classesToCompile = "ParsingNumbers.java", sourcePath = "c16/support_localization")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ParsingNumbers")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The parse() method is also used for parsing currency,
     * based on Locale
     */
    @Test
    @DisplayName("Parsing currency")
    public void parsingCurrency(
            @CompileClasses(classesToCompile = "ParsingCurrency.java", sourcePath = "c16/support_localization")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "ParsingCurrency")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Like numbers, date formats can vary
     * with Locale
     */
    @Test
    @DisplayName("Localized Date Time")
    public void localizedDateTime(
            @CompileClasses(classesToCompile = "LocalizedDateTime.java", sourcePath = "c16/support_localization")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "LocalizedDateTime")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

}
