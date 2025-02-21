import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OtherMethods {
    public static void main(String[] args) throws IOException {
        try (InputStream inputStream = new ByteArrayInputStream("Hello World!".getBytes())) {

            System.out.println("Is mark supported? " + inputStream.markSupported());
            if (inputStream.markSupported()) {
                inputStream.mark(6); // Mark at the start of input stream!
            }

            System.out.println("Printing data: " + new String(readBytes(inputStream)));
            System.out.println("Resetting stream!!!");

            inputStream.reset(); // Resetted to the marked position!

            System.out.println("Reading again from mark!");

            System.out.println("Printing data: " + new String(readBytes(inputStream))); // Rereading Hello

            System.out.println("Skipping data!");

            inputStream.skip(1L); // Skipping the white space between 'Hello' and 'World!'

            System.out.println(new String(inputStream.readAllBytes())); // Prints World without a space!

        }
    }

    public static byte[] readBytes(InputStream inputStream) throws IOException {
        int counter = 0;
        byte[] arrayOfBytes = new byte[5];
        while (counter < 5) {
            arrayOfBytes[counter] = (byte) inputStream.read();
            counter++;
        }
        return arrayOfBytes;
    }
}