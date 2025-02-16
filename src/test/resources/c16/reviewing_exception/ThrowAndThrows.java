import java.sql.SQLException;

public class ThrowAndThrows {
    public static void main(String[] args) throws SQLException {
        // The method might or might not throw a SQLException. Since this is a checked exception
        // the caller needs to handle or declare it
        throw new UnsupportedOperationException(); // Throw an UnsuppertedOperationException. Since this is a runtime exception, it does not need to be declared
    }
}