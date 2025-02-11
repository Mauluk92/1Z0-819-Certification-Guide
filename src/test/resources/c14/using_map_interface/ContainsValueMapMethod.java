import java.util.HashMap;
import java.util.Map;

public class ContainsValueMapMethod {
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        System.out.println("Checking if 1 is in the set of value of map: " + map.containsValue(1));
        System.out.println("Checking if 2 is in the set of value of map: " + map.containsValue(2));
    }
}