import java.util.ArrayList;
import java.util.List;

public class ListReplaceAllMethod {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        System.out.println(list);

        System.out.println("Adding one to each element!");
        list.replaceAll(i -> ++i);

        System.out.println(list);
    }
}