import java.util.HashMap;
import java.util.Map;

public class ForEachMapMethod {
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 4);
        map.put(2, 3);


        map.forEach((key, value) -> {
            System.out.println(String.format("key:%s, value:%s", key, value));
        });

    }
}