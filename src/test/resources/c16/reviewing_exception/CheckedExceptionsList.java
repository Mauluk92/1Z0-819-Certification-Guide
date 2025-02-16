import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.sql.SQLException;

public class CheckedExceptionsList {
    public static void main(String[] args){
        // Denotes that the attempt to open the file specified by the given pathname has failed
        System.out.println(FileNotFoundException.class.getName());
        // Signals that an I/O error has occurred (such as FileNotFoundExceptiion as a child class)
        System.out.println(IOException.class.getName());
        // Thrown when an instance is required to have a Serializable interface
        System.out.println(NotSerializableException.class.getName());
        // An exception that provides information about database access errors or other errors
        System.out.println(SQLException.class.getName());
    }
}