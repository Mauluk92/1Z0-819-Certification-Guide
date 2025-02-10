import java.util.ArrayList;
import java.util.List;

public class ListAddMethod {
    public static void main(String[] args){
        List<Integer> aList = new ArrayList<>();
        aList.add(1);
        System.out.println("First element is: " + aList.get(0));
        aList.add(0, 2);
        System.out.println("Afftering insertion of another element, first element is " + aList.get(0));
    }
}