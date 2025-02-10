import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIterator {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);

        Iterator<Integer> iterator = list.iterator();
        System.out.println("Iterating through the list");
        while (iterator.hasNext()){
            System.out.println("Getting element: " + iterator.next());
        }
        System.out.println("Ending iteration of list");
    }
}