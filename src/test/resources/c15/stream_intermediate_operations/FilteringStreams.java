import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilteringStreams {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("Filtering the list of elements: " + list);

        Stream<Integer> stream = list.stream();

        System.out.println("Elements greater than 2:");

        stream.filter(integer -> integer > 2).forEach(System.out::println);
    }
}