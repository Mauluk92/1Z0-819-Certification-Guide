import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalInstanceMethod {
    public static void main(String[] args){
        Optional<String> optional = Optional.ofNullable("Hello World!");
        Optional<String> emptyOptional = Optional.empty();
        optional.ifPresent(System.out::println); // ifPresent method accept a consumer, which will run only if optional is not empty
        System.out.println(optional.isPresent()); // Returns true in this case!
        System.out.println(emptyOptional.orElse("If empty will return this String"));
        System.out.println(emptyOptional.orElseGet(() -> "if empty this supplier is run"));
        try{
            String noContent = emptyOptional.orElseThrow();
        }catch (NoSuchElementException exception){
            System.out.println("No element found and NoSuchElementException catched: " + exception.getMessage());
        }
        try{
            String noContent = emptyOptional.orElseThrow(() -> new RuntimeException("Custom exception thrown"));
        }catch (RuntimeException exception){
            System.out.println("Custom exception catched: " + exception.getMessage());
        }

    }
}