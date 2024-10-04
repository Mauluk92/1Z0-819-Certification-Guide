public class ContinueStatement {
    public static void main(String[] args){
        int value = 0;
        while(value < 2){
            System.out.println("Loop number " + ++value);
            if(value == 1){
                System.out.println("Loop skipped, number " + value);
                continue;
            }
            System.out.println("Completed loop number " + value);
        }
    }
}