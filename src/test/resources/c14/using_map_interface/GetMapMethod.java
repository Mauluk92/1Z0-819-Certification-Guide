import java.util.HashMap;
import java.util.Map;

public class GetMapMethod {
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        System.out.println("Getting element from map: " + map.get(0));
        System.out.println("Getting element from non existent key of map: " + map.get(1));
    }
}