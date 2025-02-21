import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FlushMethod {
    public static void main(String[] args) throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            String hello = "Hello World!";
            byte[] byteArray = hello.getBytes();
            for (int i = 0; i < byteArray.length; i++) {
                outputStream.write((int) byteArray[i]);
                System.out.println("Writing into output stream!");
                if ((i + 1) % 2 == 0) {
                    System.out.println("Flushing!");
                    outputStream.flush(); // Flushing intermittently every 2 bytes!
                }
            }
            System.out.println(outputStream.toString());
        }
    }
}