import java.util.function.Predicate;

public class LocalVariableDeclaration {
    public static void main(String[] args){
        Predicate<String> valid = (String s) -> {
            boolean local = true; // Valid, since block-body lamda allow the declaration of local variables
            return s.isEmpty();
        };
        Predicate<String> notValid = (String s) -> {
            String s = "NotValid"; // This redeclaration of the parameter s is not allowed inside lambdas. Will raise compilation error
            return s.isEmpty();
        };
    }
}