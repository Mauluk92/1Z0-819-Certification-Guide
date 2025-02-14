import java.util.stream.Stream;

public class CountMethod {
    public static void main(String[] args){
        Stream<Integer> stream = Stream.of(1,2,3); // Finite Stream: for infinite Streams, count never terminates
        System.out.println("Counting the elements inside a stream: " + stream.count());
    }
}