import java.util.stream.Stream;

public class FindMethods {
    public static void main(String[] args){
        Stream<Integer> stream = Stream.of(1,2,3);
        Stream<Integer> emptyStream = Stream.empty();

        System.out.println("Finding any element in stream: ");
        stream.findAny().ifPresent(System.out::println);

        System.out.println("Finding first element in empty stream: ");
        emptyStream.findFirst().ifPresentOrElse((e) -> {
            // This block of code is never executed)
        }, () -> System.out.println("Element not found!"));
    }
}