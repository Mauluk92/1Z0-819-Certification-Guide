import java.util.HashMap;

public class NonConcurrentCollection {
    public static void main(String[] args){
        var data = new HashMap<String, Integer>();
        data.put("Hello", 1);
        data.put("World", 2);

        for(String key: data.keySet()){
            data.remove(key); // Will throw a ConcurrentModificationException at runtime!
        }
    }
}