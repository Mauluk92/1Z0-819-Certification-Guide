import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ForEachMethod {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        Stream<Integer> stream = list.stream();

        System.out.println("Looping through the list: " + list);

        stream.forEach(System.out::println);
    }
}