import java.util.Optional;

public class ChainingOptional {
    public static void main(String[] args){
        Optional<String> stringOptional = Optional.ofNullable("Hello");

        // Applying filter and map to optional of a String and printing the result

        stringOptional.filter((s) -> s.length() > 1)
                .map((s) -> s + " World!")
                .ifPresent(System.out::println);
    }
}