package it.mauluk92.java.c18;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contain tests to validate rules about waiting for result inside threads
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class WaitingForResultsTest {


}
