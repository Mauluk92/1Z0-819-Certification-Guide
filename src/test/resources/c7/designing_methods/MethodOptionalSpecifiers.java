public class MethodOptionalSpecifiers {
    public static void main(String[] args){
        ClassWithMethods classWithMethods = new SubClassWithMethods();
        classWithMethods.methodWithFinalSpecifier();
        ClassWithMethods.methodWithStaticSpecifier();
        ClassWithMethods.methodWithMoreSpecifiers();
        classWithMethods.abstractMethod();
    }
}

abstract class ClassWithMethods {

    static void methodWithStaticSpecifier(){
        System.out.println("Inside static method");
    }
    // abstract method should be overridden and defined in a subclass
    abstract void abstractMethod();

    final void methodWithFinalSpecifier(){
        System.out.println("Inside final method");
    }

    static final void methodWithMoreSpecifiers(){
        System.out.println("Inside method with more than one specifier");
    }
}

class SubClassWithMethods extends ClassWithMethods {
    @Override
    void abstractMethod() {
        System.out.println("Inside abstract method");
    }
}