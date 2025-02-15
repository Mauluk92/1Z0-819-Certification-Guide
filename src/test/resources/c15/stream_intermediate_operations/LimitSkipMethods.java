import java.util.stream.Stream;

public class LimitSkipMethods {
    public static void main(String[] args){
        Stream.iterate(1, (integer -> ++integer))
                .skip(6) // Skip the first 6 elements
                .limit(1) // Limit the result to the first element
                .forEach(System.out::println); // Prints 7
    }
}