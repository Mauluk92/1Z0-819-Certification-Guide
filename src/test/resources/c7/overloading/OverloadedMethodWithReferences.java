import java.util.Date;

public class OverloadedMethodWithReferences {
    public static void main(String[] args){
        ClassWithOverloadedMethod cls = new ClassWithOverloadedMethod();
        System.out.println("Using a string on overloaded method!");
        cls.overloadedMethod("Hello");
        System.out.println("Using a StringBuilder object on overloaded method!");
        cls.overloadedMethod(new StringBuilder());
        System.out.println("Using a java.util.Date object on overloadedMethod!");
        cls.overloadedMethod(new Date());
    }
}

class ClassWithOverloadedMethod {
    public void overloadedMethod(CharSequence charSequence){
        System.out.println("Inside CharSequence method!");
    }
    public void overloadedMethod(Object object){
        System.out.println("Inside Object method!");
    }
    public void overloadedMethod(String string){
        System.out.println("Inside String method!");
    }
}