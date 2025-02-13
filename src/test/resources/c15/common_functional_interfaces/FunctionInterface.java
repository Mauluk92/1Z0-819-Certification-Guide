import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionInterface {
    public static void main(String[] args){
        Function<String, Integer> function = String::length; // Creating a function that takes a string and returns its size
        BiFunction<String, String, Integer> biFunction = (s1, s2) -> s1.concat(s2).length(); // Creating a BiFunction

        System.out.println("Calculating size of a String: " + function.apply("Hello World!"));
        System.out.println("Calculating size of concatenated String " + biFunction.apply("Hello ", "World!"));
    }
}