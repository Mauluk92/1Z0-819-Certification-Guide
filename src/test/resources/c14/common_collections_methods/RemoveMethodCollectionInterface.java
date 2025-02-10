import java.util.ArrayList;
import java.util.Collection;

public class RemoveMethodCollectionInterface {
    public static void main(String[] args){
        Collection<Integer> collection = new ArrayList<>();
        System.out.println("Inserting element 1 to list");
        collection.add(1);
        System.out.println("Removing element 1 from list: " + collection.remove(1)); // Returns true
        System.out.println("Removing element 1 again from list: " + collection.remove(1)); // Returns false: element already removed
    }
}