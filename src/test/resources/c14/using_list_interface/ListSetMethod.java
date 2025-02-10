import java.util.ArrayList;
import java.util.List;

public class ListSetMethod {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();

        list.add(1); // Adding element 1
        list.add(2); // Adding another element: 2

        System.out.println("Current list is: ");
        System.out.println(list);

        list.set(0, 10); // Setted the first element with new element

        System.out.println("New list with new element setted is: ");
        System.out.println(list);
    }
}