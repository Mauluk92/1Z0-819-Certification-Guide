import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class RangeMethod {
    public static void main(String[] args){
        IntStream intStream = IntStream.range(1, 3); // 1, 2
        LongStream longStream = LongStream.range(1L, 3L); // 1, 2

        System.out.println("Printing integers range from 1 (inclusive) to 3 (exclusive)");
        intStream.forEach(System.out::println);
        System.out.println("Printing longs range from 1 (inclusive) to 3 (exclusive)");
        longStream.forEach(System.out::println);
    }
}