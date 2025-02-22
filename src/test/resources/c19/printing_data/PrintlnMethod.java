import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintlnMethod {
    public static void main(String[] args){
        ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayStream);

        // Printing with overloaded methods

        printStream.println(true);
        printStream.println(true);

        System.out.println(new String(byteArrayStream.toByteArray()));

        printStream.close();
    }
}