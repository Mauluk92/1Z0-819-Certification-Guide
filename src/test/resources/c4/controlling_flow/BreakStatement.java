public class BreakStatement {
    public static void main(String[] args){
        int value = 0;
        while(true){
            System.out.println("Entering the loop");
            if(value == 0){
                break; // this statement interrupts the loop
            }
        }
        System.out.println("Loop exited");
    }
}