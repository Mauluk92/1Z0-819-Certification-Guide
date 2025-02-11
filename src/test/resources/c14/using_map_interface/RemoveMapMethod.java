import java.util.HashMap;
import java.util.Map;

public class RemoveMapMethod {
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        System.out.println("Removing key 1, obtaining: " + map.remove(1));
        System.out.println("Removing again key 1, obtaining: " + map.remove(1));
    }
}