import java.io.*;

public class BufferedBinaryStreams {
    public static void main(String[] args) throws IOException {
        File file = new File(BufferedBinaryStreams.class.getResource("buffered_binary_streams.txt").getPath()); // Getting file as a resource
        try(InputStream fileInputStream = new BufferedInputStream(new FileInputStream(file))){ // Using a buffered input streams for performance enhancement
            byte[] byteArrayContent = fileInputStream.readAllBytes();
            System.out.println(new String(byteArrayContent)); // Reading file content!
        }

    }
}