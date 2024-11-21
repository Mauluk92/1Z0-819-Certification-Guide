public class UnrelatedRuntimeInvalidCast {
    public static void main(String[] args){
        StringBuilder obj = new StringBuilder();
        String objAsString = (String) obj; // Will not compile since obj is not a compatible type (is not a String but a StringBuilder!)
    }
}