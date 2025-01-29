public class ExceptionUnreachableCode {
    public static void main(String[] args){
        throw new RuntimeException();
        System.out.println("Unreachable code"); // Will not compile since runtime exception thrown before will alter the program flow making this part unreachable
    }
}