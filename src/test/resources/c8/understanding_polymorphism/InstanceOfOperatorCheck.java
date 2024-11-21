public class InstanceOfOperatorCheck {
    public static void main(String[] args){
        CharSequence obj = new StringBuilder();
        if(obj instanceof String) {
            String objAsString = (String) obj;
        }
    }
}