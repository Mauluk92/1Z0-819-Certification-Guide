import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ParsingNumbers {
    public static void main(String[] args) throws ParseException {
        String s = "40.45";

        var en = NumberFormat.getInstance(Locale.US);
        var fr = NumberFormat.getInstance(Locale.FRANCE);

        System.out.println(en.parse(s)); // a dot in United States is part of number
        System.out.println(fr.parse(s)); // France does not use a decimal point to separate numbers
    }
}