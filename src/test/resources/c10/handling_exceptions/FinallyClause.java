public class FinallyClause {
    public static void main(String[] args){
        try{
            // Protected code goes here
            System.out.println("Entered try block");
            throw new Exception();
        }catch (Exception e){
            System.out.println("Entered catch block");
            // Catch block executed;
        }finally {
            System.out.println("Entered block finally");
            // This code is executed regardless;
        }
    }
}