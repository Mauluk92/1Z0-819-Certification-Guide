import java.util.ArrayList;
import java.util.List;

public class ListGetMethod {
    public static void main(String[] args){
        List<Integer> aList = new ArrayList<>();
        aList.add(10);
        System.out.println("Getting element at index 0: " + aList.get(0));
    }
}