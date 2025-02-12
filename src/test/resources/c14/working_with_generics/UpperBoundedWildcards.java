import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpperBoundedWildcards {
    public static void main(String[] args){
        List<? extends Number> integerList = new ArrayList<Integer>(); // Valid, since Integer extends Number
        List<? extends Number> doubleList = new ArrayList<Double>(); // Also valid
        List<? extends CharSequence> charSequenceList = new ArrayList<String>(); // Valid since String class extends (or implements) CharSequence
        List<? extends IOException> exceptionList = new ArrayList<Exception>(); // Will not compile since Exception do not extends IOException but the reverse is true
    }
}