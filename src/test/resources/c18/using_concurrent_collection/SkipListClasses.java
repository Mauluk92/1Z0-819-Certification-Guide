import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

public class SkipListClasses {
    public static void main(String[] args){
        Set<String> setOfStrings = new ConcurrentSkipListSet<>();

        setOfStrings.add("C");
        setOfStrings.add("A");
        setOfStrings.add("B");

        System.out.println(setOfStrings.stream().collect(Collectors.joining(","))); // Will print A, B, C due to natural ordering of Strings

        Map<String, String> mapOfStrings = new ConcurrentSkipListMap<>();
        mapOfStrings.put("Hello!", "World!");
        mapOfStrings.put("A", "B");
        mapOfStrings.put("World", "Hello!");

        mapOfStrings.keySet().forEach(System.out::println); // Will print A, Hello!, World according to the natural ordering of Strings
    }
}