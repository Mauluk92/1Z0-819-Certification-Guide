abstract class AbstractParentClass {
    public abstract void abstractMethod(){}
}

class ConcreteSubClass extends AbstractParentClass {
    //Will not compile since this class does not override the parent abstract method
}