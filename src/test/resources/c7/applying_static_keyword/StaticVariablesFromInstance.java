public class StaticVariablesFromInstance {
    public static void main(String[] args){
        ClassWithStaticVariable classWithStaticVariable = new ClassWithStaticVariable();
        classWithStaticVariable.counter++; // Will increment the static variable
        classWithStaticVariable = null;
        classWithStaticVariable.counter++; // Will increment the counter nonetheless. Valid
        ClassWithStaticVariable.counter++; // Will increment the counter. Equally valid
        System.out.println(ClassWithStaticVariable.counter); //Will print 3

    }
}

class ClassWithStaticVariable {
    public static int counter = 0;
}