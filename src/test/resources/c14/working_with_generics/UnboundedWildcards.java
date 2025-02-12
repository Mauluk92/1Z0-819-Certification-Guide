import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcards {
    public static void main(String[] args){
        List<?> unboundedList = new ArrayList<Integer>(); // Admissible
        List<?> unboundedStringList = new ArrayList<String>(); // Admissible
    }
}