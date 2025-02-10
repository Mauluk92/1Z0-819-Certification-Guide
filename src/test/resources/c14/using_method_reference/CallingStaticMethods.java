import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class CallingStaticMethods {
    public static void main(String[] args){
        Consumer<List<Integer>> methodReference = Collections::sort;
        Consumer<List<Integer>> lambda = s -> Collections.sort(s); // Equivalent to the previous
    }
}