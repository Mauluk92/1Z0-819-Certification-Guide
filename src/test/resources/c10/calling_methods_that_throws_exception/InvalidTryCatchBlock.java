import java.io.IOException;

public class InvalidTryCatchBlock {
    public static void main(String[] args){
        NoExceptionThrower noExceptionThrower = new NoExceptionThrower();
        try{
            noExceptionThrower.throwNoException();
        }catch (IOException e){ // Will not compile since no exception is being thrown

        }
    }
}

class NoExceptionThrower {
    public void throwNoException(){}
}