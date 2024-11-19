public class NotAConstructor {
    public void NotAConstructor(String arg){
        // This is not a constructor but a method
    }

    public static void main(String[] args){
        NotAConstructor notAConstructor = new NotAConstructor("Hello"); // Will not compile since we do not have any matching constructor
    }
}