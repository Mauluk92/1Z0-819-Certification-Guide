import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class MultipleCatchBlock {
    public static void main(String[] args){
        try{
            ExceptionThrower thrower = new ExceptionThrower();
            thrower.throwExceptionFirst();
            thrower.throwExceptionSecond();
            // Protected code goes here
        }catch (FileNotFoundException e){
            // First catch block
        }catch (FileAlreadyExistsException e){
            // Secpmdp catch block
        }
    }
}

class ExceptionThrower {
    public void throwExceptionFirst() throws FileNotFoundException {

    }

    public void throwExceptionSecond() throws FileAlreadyExistsException {

    }
}