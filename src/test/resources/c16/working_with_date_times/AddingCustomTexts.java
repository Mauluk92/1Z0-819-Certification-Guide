import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class AddingCustomTexts {
    public static void main(String[] args){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd,yyyy 'at' hh:mm");
        System.out.println("Printing textual information on date: " + LocalDateTime.of(2020, Month.AUGUST, 18, 7,7,7).format(formatter));
    }
}