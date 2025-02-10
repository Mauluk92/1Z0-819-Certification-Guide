import java.util.function.Supplier;

public class CallingConstructor {
    public static void main(String[] args){
        Supplier<String> constructorReference = String::new;
        Supplier<String> lambda = () -> new String(); // Equivalent to the previous
    }
}