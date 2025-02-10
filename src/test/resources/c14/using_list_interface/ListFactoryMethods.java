import java.util.Arrays;
import java.util.List;

public class ListFactoryMethods {
    public static void main(String[] args){
        int[] arrayInt = {1, 2};
        List<Integer> aList = Arrays.asList(1,2); // List from array or varargs
        List<Integer> anotherList = List.of(1,2); // List from factory method of List interface with var args
        List<Integer> copyList = List.copyOf(anotherList); // List from another list (copy)
    }
}