import java.io.IOException;

public class HandlingExceptions {
    public static void main(String[] args){
        try {
            // Protected code
            methodThrowsException();
            // End of protected code
        } catch (IOException ex){
            // Handler for IOException

        } catch (ArithmeticException | IllegalArgumentException e) {
            // Multi catch handler
        } finally {
            // Always run after try/catch blocks are finished
        }
    }

    public static void methodThrowsException() throws IOException {
        // Throws an exception
    }
}