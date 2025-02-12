import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildcards {
    public static void main(String[] args){
        List<? super IOException> ioExceptionList = new ArrayList<Exception>(); // Works, since Exception is superclass of IOException
        List<? super Exception> exceptionList = new ArrayList<IOException>(); // Does not compile: IOException is not super classe of Exception!
    }
}