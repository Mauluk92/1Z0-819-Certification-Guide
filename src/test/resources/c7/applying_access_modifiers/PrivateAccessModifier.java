public class PrivateAccessModifier {
    public static void main(String[] args){
        ClassWithPrivateMethod aClass = new ClassWithPrivateMethod();
        aClass.aPrivateMethod(); // Does not compile since it has private access
    }
}

class ClassWithPrivateMethod {
    private void aPrivateMethod(){}
}