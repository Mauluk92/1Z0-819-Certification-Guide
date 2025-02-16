public class HandleOrDeclareRule {
    public static void main(String[] args) throws Exception {
        try {
            throw new Exception();
        }catch (Exception e) {
            // Handles exception
        }
        throw new Exception(); // This is legitimate: method signatures declares the Exception being thrown
    }
}