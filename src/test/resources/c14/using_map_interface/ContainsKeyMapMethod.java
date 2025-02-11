import java.util.HashMap;
import java.util.Map;

public class ContainsKeyMapMethod {
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        System.out.println("Does map contain key element 1? " + map.containsKey(1));
        System.out.println("Does map contain key element 2? " + map.containsKey(2));
    }
}