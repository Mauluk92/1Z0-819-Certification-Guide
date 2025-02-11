import java.util.HashMap;
import java.util.Map;

public class PutIfAbsentMapMethod {
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("Putting a new value in non existent key 1: " + map.putIfAbsent(1,1)); // Returns null
        System.out.println("Putting a new value in same key 1: " + map.putIfAbsent(1,2)); // Returns existing value: 1
    }
}