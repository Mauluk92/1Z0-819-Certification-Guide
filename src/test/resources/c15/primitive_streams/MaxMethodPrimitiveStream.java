import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MaxMethodPrimitiveStream {
    public static void main(String[] args){
        IntStream intStream = IntStream.of(1,2,3);
        LongStream longStream = LongStream.of(1L, 2L, 3L);
        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0);

        System.out.println("Getting the max from a primitive stream of integers");
        intStream.max().ifPresent(System.out::println);
        System.out.println("Getting the max from a primitive stream of longs");
        longStream.max().ifPresent(System.out::println);
        System.out.println("Getting the max from a primitive stream of doubles");
        doubleStream.max().ifPresent(System.out::println);
    }
}