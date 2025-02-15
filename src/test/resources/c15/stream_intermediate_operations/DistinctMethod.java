import java.util.ArrayList;
import java.util.List;

public class DistinctMethod {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        list.add(1);
        list.add(1);

        System.out.println("Filtering distinct elements on list: " + list);

        System.out.println("Printing unique elements");

        list.stream().distinct().forEach(System.out::println);
    }
}