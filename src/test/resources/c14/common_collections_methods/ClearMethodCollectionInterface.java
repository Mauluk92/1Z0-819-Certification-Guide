import java.util.ArrayList;
import java.util.Collection;

public class ClearMethodCollectionInterface {
    public static void main(String[] args){
        Collection<Integer> collection = new ArrayList<>();
        System.out.println("Adding an element: " + collection.add(1));
        System.out.println("Checking collection size: " + collection.size());
        System.out.println("Clearing collection");
        collection.clear();
        System.out.println("Checking collection size: " + collection.size()); // Expecting a size of 0, since collection has been cleared
    }
}