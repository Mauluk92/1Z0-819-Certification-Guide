public class ParameterList {
    public static void main(String[] args){
        ClassWithMethods classWithMethods = new ClassWithMethods();
        classWithMethods.methodWithNoParameter();
        classWithMethods.methodWithParameter("Hello!");
        classWithMethods.methodWithMultipleParameters("Hello", "World!");
    }
}

class ClassWithMethods {
    public void methodWithNoParameter(){
        System.out.println("Inside method without parameters");
    }

    public void methodWithParameter(String parameter){
        System.out.println("Inside method with a single parameter");
        System.out.printf("Parameter is: %s", parameter);
        System.out.println();
    }

    public void methodWithMultipleParameters(String parameter1, String parameter2){
        System.out.println("Inside method with multiple parameters");
        System.out.printf("Parameters are: %s, %s", parameter1, parameter2);
        System.out.println();
    }
}