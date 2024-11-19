public class DefaultConstructor {
    public static void main(String[] args) throws NoSuchMethodException{
        String defaultConstructorName = DefaultConstructor.class.getConstructor().getName();
        System.out.println("This class has the default constructor : " + defaultConstructorName);
        // Will compile since this class has a default no-arg constructor provided by the compiler
    }
}