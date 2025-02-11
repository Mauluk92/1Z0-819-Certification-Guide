import java.util.HashMap;
import java.util.Map;

public class ReplaceMapMethod {
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        System.out.println("Replacing value 1 with key 1, with a value of 2: " + map.replace(1, 2)); // Returns old value: 1
        System.out.println("Trying to replace a non existing key (7): " + map.replace(7, 7)); // Return null since the key provided is not set
    }
}