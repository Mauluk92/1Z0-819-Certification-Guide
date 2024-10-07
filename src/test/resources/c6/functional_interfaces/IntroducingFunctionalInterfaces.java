import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class IntroducingFunctionalInterfaces {
    public static void main(String[] args){
        Predicate<String> stringPredicate = new StringPredicate();
        Supplier<String> stringSupplier = new StringSupplier();
        Consumer<String> stringConsumer = new StringConsumer();

        stringConsumer.accept(stringSupplier.get());
        System.out.println(stringPredicate.test(stringSupplier.get()));
    }
}


class StringPredicate implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return s.isEmpty();
    }
}

class StringSupplier implements Supplier<String> {
    @Override
    public String get() {
        return "Hello";
    }
}

class StringConsumer implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}