import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FormatMethod {
    public static void main(String[] args){
        ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayStream);

        printStream.format("Hello, %s", "World!");

        System.out.format(new String(byteArrayStream.toByteArray())); // Printing formatted String!

        printStream.close();
    }
}