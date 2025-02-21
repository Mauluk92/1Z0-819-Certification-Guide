import java.io.*;

public class ReadingWritingStreams {
    public static void main(String[] args) throws IOException {
        try (InputStream inputStream = new ByteArrayInputStream("Hello World!".getBytes());
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            System.out.println("Reading the first byte off from InputStream");
            int firstByte = inputStream.read();
            System.out.println(new String((new byte[]{(byte) firstByte}) ));


            outputStream.write(firstByte);
            int b;
            System.out.println("Writing to output stream!");
            while (( b = inputStream.read()) != -1){
                outputStream.write(b);
            }

            System.out.println("Printing results from OutputStream: " + outputStream.toString());
        }

    }
}