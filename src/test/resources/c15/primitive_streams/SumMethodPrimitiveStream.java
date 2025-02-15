import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SumMethodPrimitiveStream {
    public static void main(String[] args){
        IntStream intStream = IntStream.rangeClosed(1, 3);
        LongStream longStream = LongStream.rangeClosed(1L, 3L);
        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0);

        System.out.println("Summing Integer Stream");
        System.out.println(intStream.sum());

        System.out.println("Summing Long Stream");
        System.out.println(longStream.sum());

        System.out.println("Summing Double Stream");
        System.out.println(doubleStream.sum());
    }
}