import java.util.Arrays;

public class PrintingStackTraces {
    public static void main(String[] args){
        try{
            throw new Exception("Custom Message");
        }catch (Exception ex){
            Arrays.stream(ex.getStackTrace()).map(StackTraceElement::getMethodName).forEach(System.out::println); // Used to print stack trace and method names
        }
    }
}