import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollectionUsage {
    public static void main(String[] args){
        var data = new ConcurrentHashMap<String, Integer>();
        data.put("Hello", 1);
        data.put("World", 2);

        for(String key: data.keySet()){
            data.remove(key); // Will NOT throw a ConcurrentModificationException at runtime!
        }
    }
}