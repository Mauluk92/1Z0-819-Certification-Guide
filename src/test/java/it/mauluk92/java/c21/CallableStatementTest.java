package it.mauluk92.java.c21;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.sql.CallableStatement;

/**
 * This class contain tests to validate rules about using {@link CallableStatement}
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class CallableStatementTest {

    /**
     * Sometimes you want your SQL to be directly in the database instead of
     * packaged with your Java code. This is particularly useful when you have many
     * queries and they are complex. A stored procedure is code that is compiled in
     * advance and stored in the database. Stored procedures are commonly written in
     * a database specific variant of SQL, which varies
     * among database software providers.
     * Using a stored procedure reduces network rounds trips.
     */
    @Test
    @DisplayName("Calling a procedure without Parameters")
    public void procedureWithoutParameters(){}

    /**
     * A stored procedure that always return the same thing is only
     * somewhat useful. We've created a new version of that stored
     * procedure that is more generic. An IN parameter is used for input
     */
    @Test
    @DisplayName("Calling a procedure with IN parameters")
    public void procedureWithINParameter(){}

    /**
     * Some stored procedure return other information. Luckily, stored procedures
     * can have OUT parameters for output
     */
    @Test
    @DisplayName("Calling a procedure with OUT parameters")
    public void procedureWithOUTParameter(){}

    /**
     * Some stored procedure return other information. Luckily, stored procedures
     * can have INOUT parameters, using the same parameter
     * for both input or output.
     */
    @Test
    @DisplayName("Calling a procedure with INOUT parameters")
    public void procedureWithINOUTParameter(){}
}
