public class InvalidUsageUninitializedFinalLocalVariables {
    public static void main(String[] args){
        final String uninitializedVariable;
        System.out.println(uninitializedVariable); // Won't compile since it is not initialized
    }
}