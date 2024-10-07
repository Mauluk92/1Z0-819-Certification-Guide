public class ComparingDifferentEqualities {
    public static void main(String[] args){
        StringBuilder sbFirst = new StringBuilder("First");
        StringBuilder sbSecond = new StringBuilder("First");

        System.out.println("We have built two stringbuilders with the same string. This means they are different objects, strictly speaking");
        System.out.println("Result of comparing the first two stringBuilder object is: ");
        System.out.println(sbFirst == sbSecond);

        System.out.println("We then append to the first another string");
        System.out.println("And register this new stringBuilder obtained to another variable");

        StringBuilder sbThird = sbFirst.append("Third");

        System.out.println("The result is: we modified the first object in place and assigned the same reference to another variable");
        System.out.println("So comparing the first with the third gives: ");
        System.out.println(sbFirst == sbThird);

        System.out.println("If we have two strings 'Hello' and 'Hello', though being different objects, they are equals!");
        System.out.println("So the result of comparing two different object strings with equals method is: ");
        System.out.println("Hello" == "Hello");

    }
}