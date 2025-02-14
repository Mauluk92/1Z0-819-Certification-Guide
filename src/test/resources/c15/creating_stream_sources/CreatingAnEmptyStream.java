import java.util.stream.Stream;

public class CreatingAnEmptyStream {
    public static void main(String[] args){
        // Creating an empty Stream
        Stream<Integer> emptyStream = Stream.empty();
        System.out.println("Counting elements of stream: " + emptyStream.count());
    }
}