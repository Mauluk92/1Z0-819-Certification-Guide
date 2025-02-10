import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class RemoveIfMethodCollectionInterface {
    public static void main(String[] args){
        Collection<Integer> collection = new ArrayList<>();
        System.out.println("Adding the following elements to list: 1,2,3,4 ");

        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);

        Predicate<Integer> predicateOnRemoval = i -> i < 4;

        System.out.println("Removing elements less than 4 strictly: " + collection.removeIf(predicateOnRemoval));
        System.out.println("Checking size of collection, expected one element remaining: " + collection.size());
    }
}