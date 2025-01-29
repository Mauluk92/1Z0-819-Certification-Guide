public class CheckedExceptionMustNotCompile {
    public static void main(String[] args){
        throw new Exception(); // Does not compile since it is not handled nor declared in the method header
    }
}