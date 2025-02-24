package it.mauluk92.java.c21;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.sql.*;

/**
 * This class contain tests to illustrate fundamentals of JDBC library (Java Database Connection)
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class IntroducingJdbcTest {

    /**
     * Data is information. A piece of data is one fact,  such as
     * your first name. A database is an organized collection of data.
     * A relation database is a database that is organized into tables,
     * which consists of rows and columns. You can think of a table as a
     * spreadsheet.
     * A relational database is accessed through structured query language (SQL).
     * SQL is a programming language used to interact with database records. Jdbc
     * works by sending a SQL command to the database and then processing
     * the response. In addition to relational databases, there is another type
     * of database called NoSQL (document oriented or graph oriented).
     */
    @Test
    @DisplayName("Intro to relational database")
    public void introToRelationalDb(){}

    /**
     * With JDBC, the concrete classes comes from the JDBC driver.
     * Each database has a different JAR file.
     * The driver JAR contains an implementation of these key interfaces in the
     * JDBC library, along with a number of other interfaces.
     * The key is that the provided implementation know how to communicate
     * with a database. What do these interfaces do? On a very high level:
     * <ul>
     *     <li>{@link Driver}: establishes a connection to the database</li>
     *     <li>{@link Connection}: sends commands to the database</li>
     *     <li>{@link PreparedStatement}: executes a SQL query</li>
     *     <li>{@link ResultSet}: reads result of a query</li>
     * </ul>
     */
    @Test
    @DisplayName("Intro to JDBC interfaces")
    public void introToJdbcInterfaces(){}

    /**
     * To access a website, you need to know the URL of the website. To access
     * a database, you need to know information about it.
     * The JDBC URL has a variety of formats. The first piece
     * is always the same, it is the protocol jdbc.
     * The second part typically contains information about the
     * database such as the location and, or name of the database.
     * Example: jdbc:postgres://localhost:5432/database_name
     */
    @Test
    @DisplayName("JDBC url")
    public void jdbcUrl(){}

    /**
     * There are two main ways to get a connection: {@link DriverManager} and {@link javax.sql.DataSource}.
     * A DataSource has more features than DriverManager. It can pool connections
     * or store the database connection information outside the application.
     * The DriverManager class is in the SDK, as it is an API that comes with Java.
     * It uses factory pattern, which means you call a static method to get a
     * connection, rather than calling a constructor. The factory
     * pattern means that you can get any implementation of the interface when calling
     * the Method.
     */
    @Test
    @DisplayName("Getting a Connection")
    public void gettingAConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        Assertions.assertTrue(conn.isValid(1));
    }
}
