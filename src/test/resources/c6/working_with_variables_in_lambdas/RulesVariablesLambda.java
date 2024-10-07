import java.util.function.Predicate;

public class RulesVariablesLambda {
    public static void main(String[] args){
        ClassWithLambda cls = new ClassWithLambda("Hello");
    }
}

class ClassWithLambda{
    int nonFinalInstanceInteger = 0;
    static int NON_FINAL_STATIC_INTEGER = 1;

    public ClassWithLambda(final String stringFinalParameter){
        final int finalLocalInteger = 2;
        int nonFinalLocalInteger = 3;

        Predicate<String> stringPredicate = (s) -> {
            System.out.println(finalLocalInteger); //Allowed
            System.out.println(nonFinalInstanceInteger); // Allowed
            System.out.println(NON_FINAL_STATIC_INTEGER); // Allowed
            System.out.println(nonFinalLocalInteger++); // Will not compile here! Because not allowed to use a non effectively final variable!
            return s.isEmpty();
        };

        stringPredicate.test(stringFinalParameter);
    }
}