package it.mauluk92.java.c21;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import org.h2.jdbc.JdbcSQLDataException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;

/**
 * This class contain tests to validate rules about using {@link PreparedStatement}
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class WorkingWithPreparedStatementTest {


    @BeforeAll
    public static void beforeAll() throws SQLException, IOException {

        ClassPathResource classPathResource = new ClassPathResource("c21/working_with_prepared_statement/table_script.sql");
        String query = String.join("\n", Files.readAllLines(classPathResource.getFile().toPath()));
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        conn.createStatement().execute(query);
    }

    /**
     * In Java, you have a choice of working with a {@link Statement},
     * {@link PreparedStatement} or {@link CallableStatement}. The latter two
     * are sub-interfaces of {@link Statement}.
     * A Statement and PreparedStatement are similar to each other, except
     * that a PreparedStatement takes parameters, while a Statement does not.
     * A Statement just executes whatever SQL query you give it.
     * While it is possible to run SQL directly with Statement,
     * you shouldn't. PreparedStatement if far superior for the following
     * reasons:
     * <ul>
     *     <li>
     *         <strong>Performance</strong>: In most programs, you run
     *          similar queries multiple times. A prepared statement figures out
     *          a plan to run the SQL well and remembers it
     *     </li>
     *     <li>
     *         <strong>Security</strong>: You are protected against an attack called
     *         SQL injection when using a PreparedStatement correctly
     *     </li>
     *     <li>
     *         <strong>Readability</strong>: It's nice not to have to deal with string
     *         concatenation in building a query string with lots of parameters
     *     </li>
     *     <li>
     *         <strong>Future use</strong>: Even if your query is being run only once
     *         or doesn't have any parameters, you should still use a PreparedStatement.
     *         That way future editors of the code won't add a variable and have to remember
     *         to change to PreparedStatement then.
     *     </li>
     * </ul>
     */
    @Test
    @DisplayName("Introducing various Statements")
    public void statements(){}

    /**
     * To run SQL, you need to tell a {@link PreparedStatement} about it.
     * An instance of PreparedStatement represents a SQL statement that you want to run
     * using the {@link Connection}. It does not actually execute the query yet!
     * SQL is not supplied at the time a {@link PreparedStatement} is requested.
     */
    @Test
    @DisplayName("Getting a prepared statement")
    public void getPreparedStatement() throws SQLException, IOException {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        // Preparing a statement

        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM TABLE_NAME");
        Assertions.assertInstanceOf(PreparedStatement.class, preparedStatement);
    }

    /**
     * Now that we have a {@link PreparedStatement}, we can run the SQL statement. The way you run
     * SQL varies depending on what kind of SQL statement it is.
     * To alter table data we typically use a method called executeUpdate().
     * The method takes the SQL statement to run as a parameter. It returns the number of rows
     * that were inserted, deleted, or changed
     */
    @Test
    @DisplayName("Using the executeUpdate() method")
    public void usingExecuteUpdateMethod() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        // Preparing statements

        PreparedStatement insertStatement = conn.prepareStatement("INSERT INTO TABLE_NAME(ID, NAME) VALUES(1, 'Hello')");
        PreparedStatement updateStatement = conn.prepareStatement("UPDATE TABLE_NAME SET NAME='World!' WHERE ID=1");
        PreparedStatement deleteStatement = conn.prepareStatement("DELETE FROM TABLE_NAME WHERE ID=1");

        // Actually executing the queries

        int inserted = insertStatement.executeUpdate();
        int updated = updateStatement.executeUpdate();
        int deleted = deleteStatement.executeUpdate();

        Assertions.assertEquals(1 , inserted);
        Assertions.assertEquals(1, updated);
        Assertions.assertEquals(1, deleted);
    }

    /**
     * To use a query that return a result, we have to use the executeQuery() method
     * which will return a {@link ResultSet}
     */
    @Test
    @DisplayName("Using executeQuery()")
    public void executeQueryMethod() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        // Preparing statement

        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM TABLE_NAME");

        Assertions.assertInstanceOf(ResultSet.class, preparedStatement.executeQuery());

    }

    /**
     * There's a third method called execute() that can run either a query
     * or an update. It returns a boolean so that we know whether there is a result set.
     * That way, we can call the proper method to get more detail
     */
    @Test
    @DisplayName("Using the execute method")
    public void usingTheExecuteMethod() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        // Preparing statements

        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM TABLE_NAME");
        PreparedStatement insertStatement = conn.prepareStatement("INSERT INTO TABLE_NAME(ID, NAME) VALUES(2, 'Hello World!')");

        boolean isResultSet = preparedStatement.execute();
        boolean isNotResultSet = insertStatement.execute();

        Assertions.assertTrue(isResultSet);
        Assertions.assertFalse(isNotResultSet);
    }

    /**
     * Prepared statements allows us to set parameters.
     * Instead of specifying value we can put a question mark (?). A <em>bind variable</em>
     * is a placeholder that lets you specify the actual values at runtime. A bind variable
     * is like a parameter. Bind variables make the SQL easier to read.
     */
    @Test
    @DisplayName("Using bing variables")
    public void usingBindVariables() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        // Preparing statements

        PreparedStatement insertStatement = conn.prepareStatement("INSERT INTO TABLE_NAME(ID, NAME) VALUES(7, ?)");
        PreparedStatement anotherInsertStatement = conn.prepareStatement("INSERT INTO TABLE_NAME(ID, NAME) VALUES(?, ?)");

        // Will execute correctly since all

        insertStatement.setString(1, "Hello World!");

        // We are missing one bind variable and will throw an exception at runtime upon execution

        anotherInsertStatement.setString(2, "Another Hello World!");

        Assertions.assertDoesNotThrow(() -> insertStatement.executeUpdate());
        JdbcSQLDataException ex1 = Assertions.assertThrows(JdbcSQLDataException.class, anotherInsertStatement::executeUpdate);

        System.out.println(ex1.getMessage());
    }
}
