import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

public class CollectStreamMethod {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        Stream<Integer> stream = list.stream();

        // Collecto method include a supplier for the collection
        // An accumulator to add a single element inside the collection provided
        // The third merges two collection into a single one

        TreeSet<Integer> treeSet = stream.collect(
                TreeSet::new,
                TreeSet::add,
                TreeSet::addAll
        );

        System.out.println("Collected: " + treeSet);
    }
}