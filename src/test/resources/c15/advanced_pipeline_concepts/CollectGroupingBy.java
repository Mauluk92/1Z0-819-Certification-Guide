import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectGroupingBy {
    public static void main(String[] args){
        Stream<String> stream = Stream.of("Hello!!", "12345", "12345", "World!!");

        Map<Integer, Set<String>> map = stream.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println("Result of grouping by: " + map);
    }
}