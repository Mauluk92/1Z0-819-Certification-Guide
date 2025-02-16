import java.io.FileNotFoundException;
import java.io.IOException;

public class RedundantMultiCatchExpression {
    public static void main(String[] args){
        try{
            throw new IOException();
        }catch (IOException | FileNotFoundException e){ // Will not compile since FileNotFound is subclass of IOException
            // Does not compile
        }
    }
}