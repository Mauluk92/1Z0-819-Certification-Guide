public class DoWhileLoops {
    public static void main(String[] args){
        boolean conditionToBeEvaluated = false;
        while(conditionToBeEvaluated){
            System.out.println("Executed while loop"); //Will never execute
        }

        do {
            System.out.println("Executed exactly one do/while loop");
        }while(conditionToBeEvaluated);
    }
}