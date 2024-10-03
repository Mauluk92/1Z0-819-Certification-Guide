public class LogicalOperatorsNullPointer {
    public static void main(String[] args){
        String nonNullObject = "Hello";
        String nullObject = null;
        // This condition will be evaluated and will be true since the first one is true (nonNullObject is not empty string)
        // Also the second condition won't be evaluated due to shortcircuit operation: it is only necessary that one of them to be true for the expression to be globally true
        boolean willExecute = !nonNullObject.isEmpty() || !nullObject.isEmpty(); // Will execute without problems

        boolean willNotExecute = !nonNullObject.isEmpty() | !nullObject.isEmpty(); // This time, both the expressions are evaluated and the last conditions raise a NullPointerException
    }
}