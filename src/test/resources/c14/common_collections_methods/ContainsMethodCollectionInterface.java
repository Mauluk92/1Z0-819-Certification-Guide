import java.util.ArrayList;
import java.util.Collection;

public class ContainsMethodCollectionInterface {
    public static void main(String[] args){
        String str = "abc";
        String anotherStr = "def";
        String equalStr = "abc";

        Collection<String> collection = new ArrayList<>();
        collection.add(str);

        System.out.println("Checking if 'abc' is contained in Collection: " + collection.contains(equalStr)); // Expected true
        System.out.println("Checking if 'def' is contained in Collection: " + collection.contains(anotherStr)); // Expected false
    }
}