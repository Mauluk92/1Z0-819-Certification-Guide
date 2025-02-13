import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConvenienceMethods {
    public static void main(String[] args){
        Consumer<String> consumer = System.out::println;
        Consumer<String> composedConsumer = consumer.andThen(s -> System.out.println("Printed string " + s));

        Function<String, Integer> function = String::length;
        Function<String, Integer> andThenFunction = function.andThen(integer -> ++integer);
        Function<String, Integer> composedFunction = function.compose(s -> "Hello: ");

        Predicate<String> predicate = String::isEmpty;
        Predicate<String> andPredicate = predicate.and(String::isBlank);
        Predicate<String> orPredicate = predicate.or(String::isBlank);

        System.out.println("Applying composed consumer!");
        composedConsumer.accept("Hello!");

        System.out.println("Applying and then function: " + andThenFunction.apply("Hello!"));
        System.out.println("Applying composed function! " + composedFunction.apply("World!"));

        System.out.println("Testing and Predicate: " + andPredicate.test(""));
        System.out.println("Testing or Predicate: " + orPredicate.test("Hello!"));
    }
}