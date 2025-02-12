public class GenericMethods {
    public static void main(String[] args){
        ClassWithGenericMethod aClass = new ClassWithGenericMethod();
        aClass.genericMethod("Hello!"); // Invoking the generic method
        aClass.<ClassToPrint>genericMethod(new ClassToPrint()); // Optional syntax for invoking a generic method
    }
}

class ClassWithGenericMethod {
    public <T> void genericMethod(T data){ // This is the syntax for generic method declaration
        System.out.println(data.toString());
    }
}

class ClassToPrint {

    @Override
    public String toString() {
        return "Inside a class";
    }
}