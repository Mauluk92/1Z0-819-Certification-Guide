import java.util.stream.Stream;

public class CreatingAVarargStream {
    public static void main(String[] args){
        // Creating a stream of three integers
        Stream<Integer> stream = Stream.of(1,2,3);
        System.out.println("Counting elements of stream: " + stream.count());
    }
}