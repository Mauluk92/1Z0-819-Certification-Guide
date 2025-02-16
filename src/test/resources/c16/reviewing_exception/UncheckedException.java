public class UncheckedException {
    public static void main(String[] args){
        throw new RuntimeException(); // Will compile, does not need to be handled or declared!
    }
}