package it.mauluk92.java.c1;

import it.mauluk92.java.testutils.JavaFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;

/**
 * This class contains tests to validate the argument passing
 * to the main method
 */
public class WritingMainMethodTest {
    /**
     * This test ensures that the arguments passed are effectively
     * used by the program itself
     * @throws IOException if an I/O error occurs while accessing the file
     */
    @Test
    @DisplayName("Arguments can be passed to the main method, which acts as a gateway to the code")
    public void passArgumentsToMainMethod() throws IOException {
        String sourcePath = new ClassPathResource("c1/writing_main_method").getFile().toPath().toString();
        String fileToRun = "PassArgumentsToMainMethod.java";
        Assertions.assertEquals(0, JavaFacade.run(List.of("ARGUMENT_01"), sourcePath, sourcePath, fileToRun));
    }


}
