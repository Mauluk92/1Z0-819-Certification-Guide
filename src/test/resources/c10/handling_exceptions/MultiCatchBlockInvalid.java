import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class MultiCatchBlockInvalid {
    public static void main(String[] args){
        try{
            // Protected code goes here
            ExceptionThrower thrower = new ExceptionThrower();
            thrower.throwExceptionFirst();
            thrower.throwExceptionSecond();
        }catch (IOException e){
            // First catch block
        }catch (FileNotFoundException e){ // Will not compile
            // Unreachable due to the fact that FileNotFoundException is a subclass of IOException in the first catch block
        }
    }
}

class ExceptionThrower {
    public void throwExceptionFirst() throws FileNotFoundException {

    }

    public void throwExceptionSecond() throws IOException {

    }
}