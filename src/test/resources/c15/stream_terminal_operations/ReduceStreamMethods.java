import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReduceStreamMethods {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        Stream<Integer> firstReduceMethod = list.stream();
        Stream<Integer> secondReduceMethod = list.stream();
        Stream<Integer> thirdReduceMethod = list.stream();

        // First overloaded method takes only the accumulator, binary operator which reduces the elements

        firstReduceMethod.reduce(Integer::sum).ifPresent((reduced) -> {
            System.out.println("Reduced element: " + reduced);
        });

        // Second overloaded method takes an identity element and accumulator

        System.out.println("Reduced element equivalent: "+ secondReduceMethod.reduce(0 , Integer::sum));

        // Third overloaded method takes an identity element, a function which preprocesses the elements and accumulator

        System.out.println("Converting to double before reducing. Result: " + thirdReduceMethod.reduce(0.0, ((aDouble, integer) -> Double.valueOf(integer) + aDouble), Double::sum));
    }
}