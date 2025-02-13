import java.time.LocalDate;
import java.util.function.Supplier;

public class SupplierInterface {
    public static void main(String[] args){
        Supplier<LocalDate> supplier1 = LocalDate::now; // Building a supplier with method reference

        LocalDate date = supplier1.get(); // Executing supplier and getting Local Date

        System.out.println("Result of supplier: " + date); // Printing supplier data provided
    }
}