import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class BoxedMethod {
    public static void mains(String[] args){
        Stream<Integer> streamInteger = IntStream.of(1,2,3).boxed();
        Stream<Long> streamLong = LongStream.of(1l, 2l, 3l).boxed();
        Stream<Double> streamDouble = DoubleStream.of(1.0, 2.0, 3.0).boxed();
    }
}