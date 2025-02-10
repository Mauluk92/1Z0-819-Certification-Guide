import java.util.ArrayList;
import java.util.List;

public class ListRemoveMethod {
    public static void main(String[] args){
        List<Integer> aList = new ArrayList<>();
        aList.add(1);
        aList.add(2);
        aList.add(3);
        System.out.println("First element is: " + aList.get(0));
        System.out.println("Removing list first element: " + aList.remove(0));
        System.out.println("First element is now: " + aList.get(0));
    }
}