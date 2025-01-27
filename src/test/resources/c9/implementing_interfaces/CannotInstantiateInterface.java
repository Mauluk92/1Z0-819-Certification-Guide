public class CannotInstantiateInterface {
    public static void main(String[] args){
        AnInterface anInterface = new AnInterface(); // Will not compile
    }
}

interface AnInterface {}