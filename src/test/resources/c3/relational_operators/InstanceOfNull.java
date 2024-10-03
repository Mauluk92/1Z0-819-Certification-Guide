public class InstanceOfNull {
    public static void main(String[] args){
        String object = "object";

        boolean firstComparison = object instanceof String; // Will compile and will return true
        boolean secondComparison = null instanceof String; // Will compile and will return false (always, regardless of type on the right)
        boolean comparisonThatWontCompile = object instanceof null; // it won't compile since it is not legal in Java
    }
}