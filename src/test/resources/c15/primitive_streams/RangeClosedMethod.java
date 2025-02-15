import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class RangeClosedMethod {
    public static void main(String[] args){
        IntStream intStream = IntStream.rangeClosed(1, 3); // 1, 2, 3
        LongStream longStream = LongStream.rangeClosed(1, 3); // 1, 2, 3

        System.out.println("Printing integers closed range from 1 to 3");
        intStream.forEach(System.out::println);
        System.out.println("Printing long closed range from 1 to 3");
        longStream.forEach(System.out::println);
    }
}