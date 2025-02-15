import java.util.Optional;
import java.util.stream.Stream;

public class PeekMethod {
    public static void main(String[] args){
        Stream<String> stream = Stream.of("Peeked", "Stream", "!");
        System.out.println("Peeking through the stream!");

        // Peeking through the stream without actually modifying the stream data!
        stream.peek(System.out::println).forEach((s) -> System.out.println("Peeked through the stream")); // Using a terminal operation, since the intermediate operation is lazily evaluated

    }
}