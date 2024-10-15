public class PassByValue {
    public static void main(String[] args){
        int argumentToBePassed = 0;
        System.out.println("Argument before being incremented inside a method: " + argumentToBePassed);
        incrementValue(argumentToBePassed);
        System.out.println("Argument after being incremented inside a method: " + argumentToBePassed);
    }

    public static void incrementValue(int argument){
        argument++;
    }
}