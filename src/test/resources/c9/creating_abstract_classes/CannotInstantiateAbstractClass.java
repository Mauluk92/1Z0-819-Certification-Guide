public class CannotInstantiateAbstractClass {
    public static void main(String[] args){
        AbstractClass absClass = new AbstractClass(); // Will not compile. Cannot instantiate abstract class
    }
}

abstract class AbstractClass {}