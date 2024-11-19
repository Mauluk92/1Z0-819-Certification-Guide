public class NoDefaultConstructor {
    public static void main(String[] args) {
        try{
            ClassWithNoDefaultConstructor.class.getConstructor(); // Will throw an exception at runtime because no constructor without arguments will be found
        }catch (NoSuchMethodException exception){
            System.out.println("No default constructor found");
            System.out.println(exception);
        }
    }
}
// This class will not have a no-arg constructor by default
class ClassWithNoDefaultConstructor {
    public ClassWithNoDefaultConstructor(String arg){}
}