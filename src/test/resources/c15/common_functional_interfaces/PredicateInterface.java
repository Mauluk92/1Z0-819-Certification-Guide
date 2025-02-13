import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateInterface {
    public static void main(String[] args){
        Predicate<String> predicate = String::isEmpty;
        BiPredicate<String, String> biPredicate = (s1, s2) -> s1.concat(s2).length() > 3;

        String s = "Hello World!";

        String s1 = "Hello ";
        String s2 = "World!";

        System.out.println("Checking first condition: " + predicate.test(s));
        System.out.println("Checking second biPredicate " + biPredicate.test(s1,s2));
    }
}