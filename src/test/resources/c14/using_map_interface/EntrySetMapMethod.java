import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntrySetMapMethod {
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet){
            System.out.println("Entry with key: " + entry.getKey());
            System.out.println("And Value with : " + entry.getValue());
        }
    }
}