import java.text.NumberFormat;
import java.util.Locale;

public class FormattingNumbers {
    public static void main(String[] args){
        int sum = 3_200_000;
        int division = sum/12;

        var us = NumberFormat.getInstance(Locale.US);
        var gr = NumberFormat.getInstance(Locale.GERMANY);

        System.out.println(us.format(division));
        System.out.println(gr.format(division));
    }
}