public class TernaryOperator {
    public static void main(String[] args){
        boolean condition;
        System.out.println("Assigning a value of " + (condition = true) + " to condition");
        conditionBranch(condition);
        System.out.println("Now executing equivalent ternary operator condition ? 1 : 0");
        System.out.println("Value returned by ternary operator: " + (condition ? 1 : 0));
        System.out.println("Assigning a value of " + (condition = false) + " to condition");
        conditionBranch(condition);
        System.out.println("Now executing equivalent ternary operator condition ? 1 : 0");
        System.out.println("Value returned by ternary operator: " + (condition ? 1 : 0));
    }

    public static int conditionBranch(boolean condition){
        if(condition){
            System.out.println("Entered if branch, returning integer 1");
            return 1;
        }else{
            System.out.println("Entered else branch, returning integer 0");
            return 0;
        }
    }
}