import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorInterface {
    public static void main(String[] args){
        UnaryOperator<Integer> unaryOperator = integer -> ++integer; // Calculate successor of integer
        BinaryOperator<Integer> binaryOperator = Integer::sum; // Sum two integers with binary operator

        System.out.println("Calculating successor of 1: " + unaryOperator.apply(1));
        System.out.println("Calculating sum of 1 and 2: " + binaryOperator.apply(1, 2));
    }
}