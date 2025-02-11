import java.util.HashMap;
import java.util.Map;

public class ReplaceAllMapMethod {
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();

        map.put(1,1);
        map.put(2,2);
        map.put(3,3);

        System.out.println("Printing map values before replaceAll");
        map.values().forEach(System.out::println);
        map.replaceAll(Integer::sum); // Sum key with value associated;
        System.out.println("Printing map values after replaceAll");
        map.values().forEach(System.out::println);
    }
}