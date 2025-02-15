import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapMethod {
    public static void main(String[] args){
        List<Integer> list1 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();

        list2.add(4);
        list2.add(5);
        list2.add(6);

        List<Integer> list3 = new ArrayList<>();

        list3.add(7);

        // Flattening the data from different lists

        Stream.of(list1, list2, list3)
                .flatMap(List::stream)
                .forEach(System.out::println);
    }
}