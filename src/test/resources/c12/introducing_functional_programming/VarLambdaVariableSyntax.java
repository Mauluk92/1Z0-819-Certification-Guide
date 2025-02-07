public class VarLambdaVariableSyntax {
    public static void main(String[] args){
        AnInterface functional = (var a, var b) -> {return true;}; // Will compile
        AnInterface functionalNotValid = (var a, String b) -> {return false;}; // Won't compile, var must be used on all parameters if at all
    }
}

@FunctionalInterface
interface AnInterface {
    boolean biValue(String a, String b);
}

