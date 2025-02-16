import java.util.MissingResourceException;

public class UncheckedExceptionsList {
    public static void main(String[] args){

        // Thrown when an exception arithmetic condition  has occurred. Division by 0 is an example
        System.out.println(ArithmeticException.class.getName());
        // Array accessed with illegal index
        System.out.println(ArrayIndexOutOfBoundsException.class.getName());
        // Storing the wrong type of object inside an array
        System.out.println(ArrayStoreException.class.getName());
        // Thrown when an inappropriate or illegal argument is passed to a method
        System.out.println(IllegalArgumentException.class.getName());
        // Signals that a resource is missing
        System.out.println(MissingResourceException.class.getName());
        // Thrown when the code is attempting to convert a string into a number and an error occurred
        System.out.println(NumberFormatException.class.getName());
        // Thrown when the code is attempting to cast an object to a sublclass of which it is not an instance
        System.out.println(ClassCastException.class.getName());
        // Signals that a method has been invoked at a wrong time (The application is not in the right state)
        System.out.println(IllegalStateException.class.getName());
        // Thrown when the application attempts to use null whenever an object is required
        System.out.println(NullPointerException.class.getName());
        // Thrown when the requested operation is not supported
        System.out.println(UnsupportedOperationException.class.getName());
    }
}