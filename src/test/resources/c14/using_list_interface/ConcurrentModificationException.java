import java.util.ArrayList;
import java.util.List;

public class ConcurrentModificationException {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        for (int integer: list){
            list.remove(integer); // Will produce a concurrent modification exception at runtime!
        }
    }
}