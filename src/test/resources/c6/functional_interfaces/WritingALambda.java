import java.util.function.Predicate;

public class WritingALambda {
    public static void main(String[] args){
        Predicate<String> stringPredicate = s -> s.isEmpty(); // Legal
        Predicate<String> stringPredicateWithParentethes = (s) -> {return s.isEmpty();}; // Equally valid
        Predicate<String> stringPredicateWithType = (String s) -> s.isEmpty(); // Valid
        System.out.println("The result of application of our lambda on string 'Hello' is: " + stringPredicate.test("Hello"));
    }
}