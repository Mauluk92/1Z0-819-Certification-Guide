import java.util.Set;

public class SetFactoryMethods {
    public static void main(String[] args){
        Set<Integer> aSet = Set.of(1,2,3);
        Set<Integer> setCopyOf = Set.copyOf(aSet);
    }
}