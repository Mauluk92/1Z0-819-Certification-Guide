public class UnreachableBranch {

    public static void main(String[] args){
        int value = 5;
        if(value < 7){
            // Reachable branch
            System.out.println("Reachable")
        }else if(value < 5){
            // Unreachable branch
        }
    }
}