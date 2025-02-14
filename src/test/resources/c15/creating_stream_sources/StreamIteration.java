import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamIteration {
    public static void main(String[] args){
        int seed = 0; // starting value
        UnaryOperator<Integer> iteration = (integer) -> ++integer; // operation
        Predicate<Integer> condition = (integer) -> integer < 8;
        System.out.println("Printing through iteration the first 8 numbers:");
        Stream.iterate(seed, condition, iteration).forEach(System.out::println);
    }
}