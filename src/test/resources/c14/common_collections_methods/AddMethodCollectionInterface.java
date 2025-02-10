import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class AddMethodCollectionInterface {
    public static void main(String[] args){
        Collection<Integer> collectionList = new ArrayList<>(); // Using array list as implementation of Collection Interface
        System.out.println("Added element 1 to list: " + collectionList.add(1)); // Operation successful
        System.out.println("Added again element 1 to list: " + collectionList.add(1)); // Operation successful: duplicates allowed
        Collection<Integer> collectionSet = new HashSet<>(); // Using set as implementation of Collection Interface
        System.out.println("Added element 1 to set: " + collectionSet.add(1)); // Operation successful
        System.out.println("Added again element 1 to set: " + collectionSet.add(1)); // Operation non successful since set does not allow duplicates
    }
}