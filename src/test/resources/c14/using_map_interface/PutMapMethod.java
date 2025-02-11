import java.util.HashMap;
import java.util.Map;

public class PutMapMethod {
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("Putting value 1 on key 1, old value is : " + map.put(1,1)); // Put the value 1 associated with key 1
        System.out.println("Putting value 2 on key 1, old value is : " + map.put(1,2)); // Put the value 2 associated with existent key 1
    }
}