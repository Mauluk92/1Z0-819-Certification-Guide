package it.mauluk92.java.c21;

import it.mauluk92.java.testutils.extension.JavaCompilerExtension;
import it.mauluk92.java.testutils.extension.JavaRunnerExtension;
import it.mauluk92.java.testutils.extension.TempDirectoryCallback;
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
 * This class contain tests to validate rules about using {@link ResultSet}
 */
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class GettingDataFromResultSetTest {

    @BeforeAll
    public static void beforeAll() throws SQLException, IOException {

        ClassPathResource classPathResource = new ClassPathResource("c21/getting_data_from_result_set/table_script.sql");
        String query = String.join("\n", Files.readAllLines(classPathResource.getFile().toPath()));
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        conn.createStatement().execute(query);
    }

    /**
     * When working with a {@link ResultSet}, most of the time you will
     * write a loop to look at each row. A ResultSet has a <em>cursor</em>,
     * which points to the current location in the data.
     * The cursor starts pointing to the location before the first row in
     * ResultSet. On the first loop iteration, rs.next() returns true,
     * and the cursor moves to point to the first row of data.
     * False means that there is no more data available to get.
     * To access data you can use both index and column name, the latter
     * being the preferred way to access data.
     */
    @Test
    @DisplayName("Using a ResultSet")
    public void usingResultSet() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");

        // Preparing statement

        PreparedStatement preparedStatement = conn.prepareStatement("SELECT ID, NAME FROM TABLE_NAME_RESULT_SET");

        // Getting data

        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()){
            String nameField = rs.getString("NAME"); // Using column label to access NAME field
            int intField = rs.getInt(1); // Using index to access ID field
            System.out.println("At index: " + rs.getRow() + ". NAME field is: " + nameField);
            System.out.println("At index: " + rs.getRow() + ". ID field is: " + intField);
        }
        Assertions.assertFalse(rs.next()); // Ensuring there is no more data available after while loop
    }

    /**
     * Attempting to access column name or index that does not exist throws
     * a {@link SQLException}, as does getting data from a {@link ResultSet}
     * when isn't pointing at a valid row. You need to be able to recognize such occurrences.
     */
    @Test
    @DisplayName("Invalid use ResultSet")
    public void invalidUseResultSet() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");

        // Preparing statement

        PreparedStatement preparedStatement = conn.prepareStatement("SELECT ID, NAME FROM TABLE_NAME_RESULT_SET");

        // Getting data

        ResultSet rs = preparedStatement.executeQuery();

        rs.next();

        Assertions.assertThrows(SQLException.class, () -> rs.getString("NON_EXISTENT_COLUMN_LABEL"));
        Assertions.assertThrows(SQLException.class, () -> rs.getString(3)); // Throws exception: out of bound

        while(rs.next()){
            Assertions.assertDoesNotThrow(() -> rs.getString(1)); // Valid
        }

        Assertions.assertThrows(SQLException.class, () -> rs.getString("NO_MORE_DATA")); // After looping through there is no more data

    }
}
