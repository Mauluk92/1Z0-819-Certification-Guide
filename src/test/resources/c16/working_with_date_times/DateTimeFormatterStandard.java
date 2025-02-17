import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterStandard {
    public static void main(String[] args){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate localDate = LocalDate.ofEpochDay(0L);

        System.out.println("Printing ISO LOCAL DATE: " + localDate.format(dateTimeFormatter));
    }
}