import java.util.HashMap;
import java.util.Map;

public class ClearMapMethod {
    public static void main(String[] args){
        Map<String, Integer> map = new HashMap<>();
        map.put("abc", 1);
        System.out.println("Getting element from map (key: abc): " + map.get("abc")); // Returns 1
        map.clear(); // Clearing the map from any keys and values
        System.out.println("Clearing map values and keys");
        System.out.println("Getting element from map again (key: abc): " + map.get("abc")); // Returns null
    }
}