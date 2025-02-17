import java.time.*;

public class FactoryMethods {
    public static void main(String[] args){
        LocalDate localDate = LocalDate.of(2020, Month.AUGUST, 18);
        LocalTime localTime = LocalTime.of(7, 7, 7);

        LocalDateTime localDateTime = LocalDateTime.of(2020, Month.AUGUST, 18, 7 ,7, 7);
        LocalDateTime anotherLocalDateTime = LocalDateTime.of(localDate, localTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, localTime, ZoneId.systemDefault());

        System.out.println("Printing Local Date: " + localDate);
        System.out.println("Printing Local Time: " + localTime);
        System.out.println("Printing Local Date Time " + localDateTime);
        System.out.println("Verifying two dates are equal: " + localDateTime.equals(anotherLocalDateTime)); // Both date are equal
        System.out.println("Printing Zoned Date Time: " + zonedDateTime);
    }
}