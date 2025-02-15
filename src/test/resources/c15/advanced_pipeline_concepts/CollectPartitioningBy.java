import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectPartitioningBy {
    public static void main(String[] args){
        Stream<String> stream = Stream.of("Long String", "Short", "Tiny", "HUUUGE!!!!!!!!");

        Map<Boolean, Set<String>> map = stream.collect(Collectors.partitioningBy((String s) -> s.length() > 5, Collectors.toSet()));

        System.out.println("Printing the values partitioned: Long and Short strings: " + map );


    }
}