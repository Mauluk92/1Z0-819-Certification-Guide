import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class AveragingStreamPrimitive {
    public static void main(String[] args){
        IntStream intStream = IntStream.of(1,2,3);
        LongStream longStream = LongStream.of(1L, 2L, 3L);
        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0);

        System.out.println("Averaging stream of integers");
        intStream.average().ifPresent(System.out::println);
        System.out.println("Averaging stream of longs");
        longStream.average().ifPresent(System.out::println);
        System.out.println("Averaging stream of doubles");
        doubleStream.average().ifPresent(System.out::println);
    }
}