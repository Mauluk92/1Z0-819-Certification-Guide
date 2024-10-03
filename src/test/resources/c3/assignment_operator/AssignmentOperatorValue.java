public class AssignmentOperatorValue {
    public static void main(String[] args){
        boolean falseValue = false;
        int integerValue = 5;
        if(falseValue = true){ // the result of this assignment is true, so it will compile and the condition be satisfied
            if(integerValue = 3){ // the result of this assignment is 3, so it won't compile since it is required a boolean
                // unreachable code
            }
        }
    }
}