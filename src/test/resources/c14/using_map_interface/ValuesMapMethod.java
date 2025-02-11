import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ValuesMapMethod {
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);

        Collection<Integer> collectionValues = map.values();
        System.out.println("Printing value from map!");
        collectionValues.forEach(System.out::println);
    }
}