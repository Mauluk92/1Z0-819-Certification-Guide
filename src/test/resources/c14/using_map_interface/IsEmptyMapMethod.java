import java.util.HashMap;
import java.util.Map;

public class IsEmptyMapMethod {
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("Checking if map empty: " + map.isEmpty());
    }
}