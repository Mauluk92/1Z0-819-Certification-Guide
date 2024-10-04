public class LoopLabels {
    public static void main(String[] args){
        int i = 0;
        LABEL_OUTER_LOOP: while(true){
            System.out.println("Entering infinite outer loop");
            System.out.println("Entering infinite inner loop");
            while(true){
                System.out.println("Inner loop, number " + ++i);
                if(i > 2){
                    System.out.println("Entering if condition");
                    System.out.println("Interruping outer infinite loop");
                    break LABEL_OUTER_LOOP;
                }
            }
        }
    }
}