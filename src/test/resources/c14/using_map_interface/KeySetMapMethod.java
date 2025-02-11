import java.util.HashMap;
import java.util.Map;

public class KeySetMapMethod {
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);

        System.out.println("Iterating through key set");
        for (int key : map.keySet()){
            System.out.println("key: " + key);
        }
    }
}