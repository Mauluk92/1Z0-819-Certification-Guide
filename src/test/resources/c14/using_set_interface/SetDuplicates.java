import java.util.HashSet;
import java.util.Set;

public class SetDuplicates {
    public static void main(String[] args){
        Set<Integer> set = new HashSet<>();
        System.out.println("Adding 1 to set: " + set.add(1));
        System.out.println("Adding 2 to set: " + set.add(2));
        System.out.println("Adding 1 again to set: " + set.add(1));
    }
}