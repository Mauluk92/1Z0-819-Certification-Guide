import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocalizedDateTime {
    public static void main(String[] args){
        LocalDateTime localDateTime = LocalDateTime.of(2020, Month.AUGUST, 18, 7, 7, 7);

        Locale localeIT = Locale.ITALY;
        Locale localeUS = Locale.US;

        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(localeIT).format(localDateTime));
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(localeUS).format(localDateTime));
    }
}