import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerInterface {
    public static void main(String[] args){
        Consumer<String> consumer = System.out::println; // Creating a consumer
        BiConsumer<String, String> biConsumer = (s1, s2) -> System.out.println(s1+s2); // Creating a biconsumer

        String s1 = "Hello World!";
        String s2 = "Hello ";
        String s3 = "World!";

        consumer.accept(s1); // Consume a given string
        biConsumer.accept(s2,s3); // Consume two strings
    }
}