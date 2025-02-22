import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintMethod {
    public static void main(String[] args){
        ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayWriter = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayStream);
        PrintWriter printWriter = new PrintWriter(byteArrayWriter);

        // Printing with overloaded methods

        printStream.print(true);
        printWriter.print(true);

        System.out.println(new String(byteArrayStream.toByteArray()));
        System.out.println(new String(byteArrayWriter.toByteArray()));

        printStream.close();
        printWriter.close();
    }
}