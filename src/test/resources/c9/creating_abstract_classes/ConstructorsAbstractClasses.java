public class ConstructorsAbstractClasses {
    public static void main(String[] args){
        ConcreteSubClass concreteSubClass = new ConcreteSubClass();
    }
}

abstract class AbstractClass {
    public AbstractClass(){
        System.out.println("Entering abstract parent class constructor");
        System.out.println("Exiting abstract parent class constructor");
    }
}

class ConcreteSubClass extends AbstractClass {
    // The compiler will insert a default no arg constructor here
    // Also will insert a default call to super(), the parent no arg constructor invoking thus
    // effectively the parent abstract no arg constructor
}