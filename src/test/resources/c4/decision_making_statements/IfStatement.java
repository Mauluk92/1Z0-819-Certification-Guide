public class IfStatement {
    public static void main(String[] args){
        int intValue = 5;
        String stringObj = "Hello!";
        boolean expression = intValue == 5;
        boolean elseExpression = stringObj.length() > 3;

        if(expression){
            System.out.println("Inside if block statement");
        }

        if(!elseExpression){
            // Not reached
        }else{
            System.out.println("Inside else block statement");
        }
    }
}