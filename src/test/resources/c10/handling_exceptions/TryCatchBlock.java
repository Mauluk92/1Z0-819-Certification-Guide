public class TryCatchBlock {
    public static void main(String[] args){
        try{
            System.out.println("An exception occur in the try block");
            // Protected code goes here
            throw new Exception();
        }catch (Exception ex){
            System.out.println("Entered catch block");
        }
    }
}