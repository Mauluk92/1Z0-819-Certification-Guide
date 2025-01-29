public class UncheckedExceptionClasses {
    public static void main(String[] args){
        System.out.println();
        System.out.println(ArithmeticException.class.getName());
        System.out.println("This exception is thrown when attempting to divide by 0");
        System.out.println();
        System.out.println(ArrayIndexOutOfBoundsException.class.getName());
        System.out.println("This exception is thrown when attempting to access an element inside an array which does not exists");
        System.out.println();
        System.out.println(ClassCastException.class.getName());
        System.out.println("This exception is thrown when a cast to an unrelated type is attempted");
        System.out.println();
        System.out.println(NullPointerException.class.getName());
        System.out.println("This exception is thrown when invoking, for example, any method on a null object reference");
        System.out.println();
        System.out.println(IllegalArgumentException.class.getName());
        System.out.println("This exception is thrown when a wrong argument is used inside a method parameter list");
        System.out.println();
        System.out.println(NumberFormatException.class.getName());
        System.out.println("This exception is thrown when the program attempts to format a string as a number and cannot do it");
    }
}