import java.util.List;

public class InvalidOverloadedMethodsGenerics {
    public void notValid(List<String> aList){}
    public void notValid(List<Integer> aList){} // Won't compile, after type erasure, both methods will have the same type
}