import java.io.*;

public class TextualIOStreams {
    public static void main(String[] args) throws IOException {
        File file = new File(TextualIOStreams.class.getResource("textual_io_streams.txt").getPath()); // Getting file as a resource
        try(FileReader fileReader = new FileReader(file)){
            int character;
            while((character = fileReader.read()) != -1){
                System.out.println("Reading individual character with FileReader!");
            }
        }

        try(BufferedReader fileReader = new BufferedReader(new FileReader(file))){
            String line;
            System.out.println("Reading lines with BufferedReader!");
            while((line = fileReader.readLine()) != null){
                System.out.println(line);
            }
        }

    }
}