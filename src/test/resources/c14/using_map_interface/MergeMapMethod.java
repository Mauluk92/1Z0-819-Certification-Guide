import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MergeMapMethod {
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();

        map.put(1,1);
        map.put(2,2);
        map.put(3,3);

        map.merge(4, 4, Integer::sum); // If key is not present, put 4, otherwise replace with sum of old and new value
        System.out.println("Merging map: " + map.get(4));

        map.merge(1,1, Integer::sum); // This time the merge function is executed, therefore now key 1 has value 2
        System.out.println("Merging map: " + map.get(1));

        map.merge(2,2, (oldValue, newValue) -> null); // This time the key 2 is removed since the merge function return null
        System.out.println("Merging map: " + map.get(2));
    }
}