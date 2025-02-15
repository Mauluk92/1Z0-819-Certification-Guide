import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorMapping {
    public static void main(String[] args){
        Stream<String> stream = Stream.of("Hello", "Yet another String", "World!");
        Map<Integer, Long> map = stream.collect(Collectors.groupingBy(String::length, Collectors.mapping(s -> s.charAt(0), Collectors.counting())));

        System.out.println("Printing partitioned map: " + map);
    }
}