public class NotUsingUninitializedFinalLocalVariableCompile {
    public static void main(String[] args){
        final String uninitializedVariable;
        System.out.println("Fine, will compile as long we do not use the variable");
    }
}