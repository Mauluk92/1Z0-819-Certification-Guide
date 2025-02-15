import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class CreatingPrimitiveStreams {
    public static void main(String[] args){
        // IntStream can be used for int, short, byte and char
        IntStream intStream = IntStream.of(1,2,3); // Creating an IntStream
        // LongStream can be used for long primitives
        LongStream longStream = LongStream.of(1L,2L,3L); // Creating a LongStream
        // Double stream can be used either for float or dobules
        DoubleStream doubleStream = DoubleStream.of(1.0,2.0,3.0); // Creating a DoubleStream
    }
}