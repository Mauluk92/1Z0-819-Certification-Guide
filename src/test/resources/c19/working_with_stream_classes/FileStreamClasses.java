import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamClasses {
    public static void main(String[] args) throws IOException {
        File file = new File(FileStreamClasses.class.getResource("file_stream_classes.txt").getPath()); // Getting file as a resource
        try(FileInputStream fileInputStream = new FileInputStream(file)){
            byte[] byteArrayContent = fileInputStream.readAllBytes();
            System.out.println(new String(byteArrayContent)); // Reading file content!
        }

    }
}