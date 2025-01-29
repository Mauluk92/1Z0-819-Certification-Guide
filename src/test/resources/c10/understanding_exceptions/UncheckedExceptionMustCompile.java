public class UncheckedExceptionMustCompile {
    public static void main(String[] args){
        throw new RuntimeException(); // Will compile since runtime do not need to be declared or handled
    }
}