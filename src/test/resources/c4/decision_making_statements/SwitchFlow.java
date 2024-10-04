public class SwitchFlow {
    public static void main(String[] args){
        int value = 0;
        // The code will execute all three branches, case 0, case 1, and default, in this order
        switch (value){

            case 0: {
                System.out.println("First branch we have a value of " + value);
                System.out.println("Now has a value of " + ++value);
            }
            case 1: {
                System.out.println("Second branch we have a value of " + value);
                System.out.println("Now has a value of " + ++value);
            }
            default: System.out.println("Final value is : " + value);
        }
    }
}