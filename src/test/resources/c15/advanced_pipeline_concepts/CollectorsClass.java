import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsClass {
    public static void main(String[] args){
        var joiningCollector = Collectors.joining(","); // Collector to join multiple string with a comma
        var averagingIntCollector = Collectors.<Integer>averagingInt(Integer::valueOf); // Collector to average int values
        var predicateFilteringCollector = Collectors.filtering((String s) -> !s.isEmpty(), Collectors.counting()); // Collector to filter non empty strings and counting the result set
        var collectorFlatMapping = Collectors.flatMapping(Stream::of, Collectors.counting()); // Collector that flattens out the stream and counts the result

        List<String> list = List.of("Hello!", "Hello World!", "");
        List<String> anotherList = List.of("Hello!", "Another World!");

        List<List<String>> nestedList = List.of(list, anotherList);

        System.out.println(list.stream().collect(joiningCollector));
        System.out.println(list.stream().map(String::length).collect(averagingIntCollector));
        System.out.println(list.stream().collect(predicateFilteringCollector));
        System.out.println(nestedList.stream().collect(collectorFlatMapping));

    }
}