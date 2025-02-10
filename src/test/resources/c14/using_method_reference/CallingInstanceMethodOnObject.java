import java.util.function.Consumer;
import java.util.function.Predicate;

public class CallingInstanceMethodOnObject {
    public static void main(String[] args){
        String str = "abc";
        Predicate<String> methodReference = str::startsWith;
        Predicate<String> lambda = s -> str.startsWith(str); // Equivalent to the previous
    }
}