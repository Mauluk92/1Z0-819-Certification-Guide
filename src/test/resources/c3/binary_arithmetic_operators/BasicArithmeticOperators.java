public class BasicArithmeticOperators {
    public static void main(String[] args){
        int valueFirst = 5;
        int valueSecond = 4;
        System.out.println("First value is " + valueFirst + " while second value is " + valueSecond);
        System.out.println("Addition operator " + (valueFirst + valueSecond));
        System.out.println("Subtraction operator " + (valueFirst - valueSecond));
        System.out.println("Multiplication operator " + (valueFirst * valueSecond));
        System.out.println("Division operator on both integers " + (valueFirst / valueSecond));
        System.out.println("Division operator when first (or any) operand is double or float " + (((double)valueFirst)/valueSecond));
    }
}