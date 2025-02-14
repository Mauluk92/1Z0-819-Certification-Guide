import java.util.NoSuchElementException;
import java.util.Optional;

public class CreatingAnOptional {
    public static void main(String[] args){
        try{
            System.out.println("Creating an empty Optional");
            Optional<String> emptyOptional = Optional.empty();
            System.out.println("Accessing empty Optional: " + emptyOptional.get());
        }catch (NoSuchElementException exception){
            System.out.println("No element found: NoSuchElementException catched!");
            System.out.println(exception.getMessage());
        }
        System.out.println("Creating a valid Optional");
        Optional<String> optional = Optional.of("Hello World!");
        System.out.println("Accessing valid Optional: " + optional.get());
    }
}