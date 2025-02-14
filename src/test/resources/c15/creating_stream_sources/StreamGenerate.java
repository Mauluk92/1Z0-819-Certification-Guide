import java.util.stream.Stream;

public class StreamGenerate {
    public static void main(String[] args){
        System.out.println("Generating 7 elements from generate method of stream:");
        Stream.generate(() -> 1).limit(7).forEach(System.out::println); // Limit is used to terminate an infinite stream of elements
    }
}