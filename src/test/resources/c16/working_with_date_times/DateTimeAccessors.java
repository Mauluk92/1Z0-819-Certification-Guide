import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeAccessors {
    public static void main(String[] args){
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2020, 7, 18, 7, 7, 7, 0, ZoneId.systemDefault());
        System.out.println(zonedDateTime);
        System.out.println("Year: " + zonedDateTime.getYear());
        System.out.println("Month: " + zonedDateTime.getMonth());
        System.out.println("Day: " + zonedDateTime.getDayOfMonth());
        System.out.println("Day of week: " + zonedDateTime.getDayOfWeek().name());
        System.out.println("Hour: " + zonedDateTime.getHour());
        System.out.println("Minute: " + zonedDateTime.getMinute());
        System.out.println("Second: " + zonedDateTime.getSecond());
        System.out.println("Zone: " + zonedDateTime.getZone());
    }
}