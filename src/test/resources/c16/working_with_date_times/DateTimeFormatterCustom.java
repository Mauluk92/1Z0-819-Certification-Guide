import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterCustom {
    public static void main(String[] args){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(0L, 0, ZoneOffset.UTC);
        System.out.println("Printing custom pattern date time string: " + localDateTime.format(dateTimeFormatter));
    }
}