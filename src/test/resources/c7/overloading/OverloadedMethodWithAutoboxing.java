public class OverloadedMethodWithAutoboxing {
    public static void main(String[] args){
        int primitive = 0;
        Integer wrapper = 0;
        long longPrimitive = 0L;
        ClassWithOverloadedWrapper classWithOverloadedWrapper = new ClassWithOverloadedWrapper();
        System.out.println("Using int primitive value");
        classWithOverloadedWrapper.overloadedMethod(primitive);
        System.out.println("Using int wrapper value");
        classWithOverloadedWrapper.overloadedMethod(wrapper);
        System.out.println("Using a long primitive value with a method with wrapper class in parameter list");
        classWithOverloadedWrapper.overloadedMethod(longPrimitive);
    }
}

class ClassWithOverloadedWrapper {
    public void overloadedMethod(Integer integerWrapper){
        System.out.println("Inside method with Integer wrapper class");
    }

    public void overloadedMethod(int integerPrimitive){
        System.out.println("Inside method with int primitive value");
    }

    public void overloadedMethod(Long longWrapper){
        System.out.println("Inside method with Long wrapper class");
    }
}