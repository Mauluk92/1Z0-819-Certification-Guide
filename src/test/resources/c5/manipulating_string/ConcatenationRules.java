public class ConcatenationRules {
    public static void main(String[] args){
        System.out.println("'2 + 3' equals 5 due to first rule of concatenation: " + (2+3));
        System.out.println("'2 + a' where a is a string equals '2a' due to the second rule of concatenation: " + (2 + "a"));
        System.out.println("If we take \"2\" as a string and add to '(2 + 3)' we have another string because expression is evaluated left to right: " + ("2" + (2 + 3)));
        System.out.println("If we add a char (a) to a number get a number because char is a numeric type: " + (2 + 'a'));
    }
}