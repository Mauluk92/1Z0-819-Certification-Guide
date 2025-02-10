import java.util.ArrayList;
import java.util.Collection;

public class IsEmptySizeMethodsCollectionInterface {
    public static void main(String[] args){
        Collection<Integer> collection = new ArrayList<>();
        System.out.println("Checking if collection is empty: " + collection.isEmpty());
        System.out.println("Checking how many elements the collection has: " + collection.size());
    }
}