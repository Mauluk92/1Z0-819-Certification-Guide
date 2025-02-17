import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ParsingCurrency {
    public static void main(String[] args) throws ParseException {
        String income = "$92,807.99";
        var cf = NumberFormat.getCurrencyInstance(Locale.US);

        double value = (Double) cf.parse(income);
        System.out.println(value); // Prints 92807.99
    }
}