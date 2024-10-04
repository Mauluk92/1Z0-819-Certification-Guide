import java.util.ArrayList;
import java.util.List;

public class ForEachLoop {
    public static void main(String[] args){
        String[] arrayOfStrings = new String[]{"Hello", "World", "from", "an", "array"};
        System.out.println("Executing for each Loop inside an array");
        for(String value: arrayOfStrings){
            System.out.println(value);
        }

        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("Hello");
        listOfStrings.add("World");
        listOfStrings.add("from");
        listOfStrings.add("a");
        listOfStrings.add("list!");
        System.out.println("Executing for each Loop inside a list");
        for (String value: listOfStrings){
            System.out.println(value);
        }
    }
}