import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;

public class OperatingOnFiles {
    public static void main(String[] args){

        File file = new File(OperatingOnFiles.class.getResource("operating_on_files.txt").getPath()); // Getting file as a resource
        File nonExistentFile = new File("non_existent_file.txt");
        System.out.println("Deleting non existent file: " + nonExistentFile.delete());
        System.out.println("Checking if file exists: " + file.exists());
        System.out.println("Getting absolute path from file: " + file.getAbsolutePath());
        System.out.println("Getting parent path from file: " + file.getParent());
        System.out.println("Checking if it is directory: " + file.isDirectory());
        System.out.println("Checking if it is a file: " + file.isFile());
        System.out.println("Checking last modified " + file.lastModified());
    }
}