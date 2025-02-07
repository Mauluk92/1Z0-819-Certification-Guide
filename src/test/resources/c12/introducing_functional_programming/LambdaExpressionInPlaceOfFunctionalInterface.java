public class LambdaExpressionInPlaceOfFunctionalInterface {
    public static void main(String[] args){
        ValidFunctionalInterface firstImpl = new ValidFunctionalInterface() {
            @Override
            public boolean isOk() {
                return true;
            }
        };
        ValidFunctionalInterface secondImpl = () -> true; // inline lambda expression
    }
}

@FunctionalInterface
interface ValidFunctionalInterface{
    boolean isOk();
}