import java.util.function.Predicate;

public class LambdaExpressionSyntax {
    public static void main(String[] args){
        // Both syntax are correct
        Predicate<String> baseSyntax = a -> a.isEmpty();
        Predicate<String> completeSyntax = (String a) -> {return a.isEmpty();};
    }
}