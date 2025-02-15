import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SummaryStatisticsPrimitiveStream {
    public static void main(String[] args){
        IntSummaryStatistics intSummaryStatistics = IntStream.rangeClosed(1, 3).summaryStatistics();
        DoubleSummaryStatistics doubleSummaryStatistics = DoubleStream.of(1.0, 2.0, 3.0).summaryStatistics();
        LongSummaryStatistics longSummaryStatistics = LongStream.range(1L, 3L).summaryStatistics();

        // These Streams can be used to obtain different terminal operations without consuming the stream
    }
}