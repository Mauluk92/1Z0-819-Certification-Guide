import java.util.HashMap;
import java.util.Map;

public class DiamondOperatorIncorrectUsage {
    public static void main(String[] args){
        Map<> invalid = new HashMap<Integer, Integer>(); // Will not compile since diamond operator can be used only on initialization;
    }
}