import java.util.Comparator;
import java.util.stream.Stream;

public class MinMaxMethods {
    public static void main(String[] args){
        Stream<String> stream = Stream.of("tiny", "longest");
        Stream<String> anotherStream = Stream.of("tiny", "longest"); // create another stream since using a terminal operation prevents that stream to be used again
        Comparator<String> stringComparator = (s1, s2) -> Integer.compare(s1.length(), s2.length()); // Comparator to confronts strings based on their length
        System.out.println("Shortest string is: " + stream.min(stringComparator).get()); // prints "tiny"
        System.out.println("Longest string is: " + anotherStream.max(stringComparator).get()); // prints "longest"
    }
}