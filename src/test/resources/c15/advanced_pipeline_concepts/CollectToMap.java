import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectToMap {
    public static void main(String[] args){
        Stream<String> stream = Stream.of("Hello", "Another String", "", "Hello");

        // Collecting string by their length as key and merging same recod by concatening strings

        Map<Integer, String> map = stream.collect(Collectors.toMap(String::length, Function.identity(), (s1, s2) -> s1.concat(s2), TreeMap::new));
        System.out.println(map);

    }
}