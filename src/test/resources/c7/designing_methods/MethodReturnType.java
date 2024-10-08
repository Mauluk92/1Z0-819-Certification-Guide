public class MethodReturnType {
    public static void main(String[] args){
        ClassWithMethod classWithMethod = new ClassWithMethod();
        classWithMethod.argumentWithoutReturn(); // Valid, since the return type is the keyword void
        classWithMethod.argumentWithEmptyReturn(); // Valid, you can also put an empty return inside body, which can be omitted in void return type
        classWithMethod.argumentWithReturnType(); // Return statement is mandatory
    }
}

class ClassWithMethod {
    public void argumentWithoutReturn(){
        System.out.println("Inside method without return type");
    }

    public void argumentWithEmptyReturn(){
        System.out.println("Inside method with empty return");
        return;
    }

    public String argumentWithReturnType(){
        System.out.println("Inside method with return type");
        return "Hello World!";
    }
}