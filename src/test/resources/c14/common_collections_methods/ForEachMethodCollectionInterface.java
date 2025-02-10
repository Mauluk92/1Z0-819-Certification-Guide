import java.util.ArrayList;
import java.util.Collection;

public class ForEachMethodCollectionInterface {
    public static void main(String[] args){
        Collection<Integer> collection = new ArrayList<>();

        collection.add(0);
        collection.add(1);
        collection.add(2);

        System.out.println("Printing elements inside collection with forEach: ");

        collection.forEach(System.out::println); // Using method reference via static method
    }
}