public class StringPool {
    public static void main(String[] args){
        String x = "Hello!";
        String y = "Hello!";

        // These two strings are equals!
        System.out.println("We have created two string literals with the same content: those string will be equal under == operator");
        System.out.println(x == y);
        System.out.println("Now we create two strings with the new operator");

        x = new String("Hello");
        y = new String("Hello");

        System.out.println("Those two strings will be different under the == operator");
        System.out.println(x == y);

        System.out.println("But, if we use the intern() method, we get the same string, even if we forced the creation out of string pool");
        x = "Hello";
        y = y.intern();
        System.out.println(x == y);
    }
}