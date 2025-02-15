import java.util.Comparator;
import java.util.stream.Stream;

public class SortedMethod {
    public static void main(String[] args){
        Stream<String> stream = Stream.of("Hello", "Hi", "!");
        Comparator<String> customComparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        // Printing sorted stream of elements
        stream.sorted(customComparator).forEach(System.out::println);
    }
}