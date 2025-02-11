import java.util.HashMap;
import java.util.Map;

public class GetOrDefaultMapMethod {
    public static void main(String[] args){
        Map<String, Integer> map = new HashMap<>();
        map.put("abc", 1);
        System.out.println("Getting existent element with key 'abc': " + map.get("abc"));
        System.out.println("Getting non existent element with key 'def': " + map.getOrDefault("def", 7));
    }
}