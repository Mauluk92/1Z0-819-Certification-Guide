public class PrimitiveFinalLocalVariableCannotChangeItsValue {
    public static void main(String[] args){
        final int initialized = 0;
        initialized = 1; // Will not compile since initialized variable has been already initialized
    }
}