import java.util.function.Predicate;

public class ReferencingOutsideVariables {
    public static void main(String[] args){
        final String finalVariable = "Final local variable"; // Final variables are fine
        String effectivelyFinalVariable = "Effectively final local variable"; // even though this variable is not final, it is not change during the lambda block or anywhere else
        String nonFinalVariable = "Non final variable";

        Predicate<String> isEmptyPredicate = s -> {

            boolean isEmptyFinal = finalVariable.isEmpty();
            boolean isEmptyEffectivelyFinal = effectivelyFinalVariable.isEmpty();
            nonFinalVariable = "Reassigned"; // Not valid, wil cause a compilation error: variables referenced from the lambda body must be final or effectively final
            return nonFinalVariable.isEmpty();

        };
    }
}