public class ErrorExceptionClasses {
    public static void main(String[] args){
        System.out.println();
        System.out.println(ExceptionInInitializerError.class.getName());
        System.out.println("This exception is thrown whenever an unhadled exception in a static initializer block is thrown");
        System.out.println();
        System.out.println(StackOverflowError.class.getName());
        System.out.println("This exception is thrown whenever the stack is out of room");
        System.out.println();
        System.out.println(NoClassDefFoundError.class.getName());
        System.out.println("This exception is thrown whenever a class available at compile time is not available at runtime");
    }
}