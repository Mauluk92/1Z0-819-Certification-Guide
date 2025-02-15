import java.util.stream.Stream;

public class MapMethod {
    public static void main(String[] args){
        Stream<String> stream = Stream.of("Hello", "World", "!");
        System.out.println("Printing length of strings using map method:");
        stream.map(String::length).forEach(System.out::println);
    }
}