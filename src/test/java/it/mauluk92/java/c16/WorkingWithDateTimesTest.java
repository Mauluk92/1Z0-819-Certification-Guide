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
 * This class contain tests to validate rules about try with dates and times
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class WorkingWithDateTimesTest {

    /**
     * Java includes numerous classes to model
     * date and times, listed here: {@link java.time.LocalDate},
     * {@link java.time.LocalTime}, {@link java.time.LocalDateTime},
     * {@link java.time.ZonedDateTime}
     */
    @Test
    @DisplayName("Classes for Dates and Times")
    public void dateTimesClasses(
            @CompileClasses(classesToCompile = "DateTimesClasses.java", sourcePath = "c16/working_with_date_times")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "DateTimesClasses")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * We can create some dates and times values using
     * the of() methods in each class
     */
    @Test
    @DisplayName("Factory methods date and times")
    public void factoryMethods(
            @CompileClasses(classesToCompile = "FactoryMethods.java", sourcePath = "c16/working_with_date_times")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "FactoryMethods")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * The date and time classes support many methods
     * to get data out of them (months, days and so on)
     */
    @Test
    @DisplayName("Date time accessor methods")
    public void dateTimeAccessors(
            @CompileClasses(classesToCompile = "DateTimeAccessors.java", sourcePath = "c16/working_with_date_times")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "DateTimeAccessors")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Java provides a class called DateTimeFormatter
     * to display standard formats (ISO for example)
     */
    @Test
    @DisplayName("DateTimeFormatter standard formats")
    public void dateTimeFormatterStandard(
            @CompileClasses(classesToCompile = "DateTimeFormatterStandard.java", sourcePath = "c16/working_with_date_times")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "DateTimeFormatterStandard")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * If you don't want to use one of the predefined
     * formats, DateTimeFormatter supports a custom
     * format using a date format string
     */
    @Test
    @DisplayName("DateTimeFormatter custom formats")
    public void dateTimeFormatterCustom(
            @CompileClasses(classesToCompile = "DateTimeFormatterCustom.java", sourcePath = "c16/working_with_date_times")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "DateTimeFormatterCustom")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * What if you want your format to include some custom text
     * values? If you just type it as part of the format String,
     * the formatter will interpret each character as a date/time
     * symbol. In the best case, it will display weird data based on extra symbols
     * you enter. In the worst case, it will throw an exception because
     * the characters contain invalid symbols.
     * We can achieve this by using single quotes (')
     **/
    @Test
    @DisplayName("Adding custom texts")
    public void addingCustomTexts(
            @CompileClasses(classesToCompile = "AddingCustomTexts.java", sourcePath = "c16/working_with_date_times")
            Integer outputCompilation,
            @ExecuteJavaProgram(mainClass = "AddingCustomTexts")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
