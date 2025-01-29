import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckedExceptionClasses {
    public static void main(String[] args){
        System.out.println();
        System.out.println(IOException.class.getName());
        System.out.println("This exception is thrown whenever an Input/Output error occurs");
        System.out.println();
        System.out.println(FileNotFoundException.class.getName());
        System.out.println("This exception is thrown whenever attempting to access a File that does not exists");
    }
}