import java.util.function.Predicate;

public class CallingInstanceMethodOnParameter {
    public static void main(String[] args){
        Predicate<String> methodReference = String::isEmpty;
        Predicate<String> lambda = s -> s.isEmpty(); // Equivalent to the previous
    }
}