import java.io.FileNotFoundException;
import java.io.IOException;

public class UnreachableCatchBlock {
    public static void main(String[] args){
        try{
            throw new IOException();
        }catch (IOException e){
            // Broader exception block
        }catch (FileNotFoundException e){ // Will not compile since FileNotFound is more specific than IOException!
            // Unreachable block
        }
    }
}