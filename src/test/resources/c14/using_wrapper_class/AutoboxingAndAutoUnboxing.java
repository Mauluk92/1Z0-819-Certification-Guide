import java.util.ArrayList;
import java.util.List;

public class AutoboxingAndAutoUnboxing {
    public static void main(String[] args){
        List<Integer> autoboxedList = new ArrayList<>();
        autoboxedList.add(null); // Since it is a wrapper class, it can be null!
        Integer autoboxedValue = autoboxedList.get(0); // Valid, it is null
        int unboxedValue = autoboxedList.get(0); // Not valid, will raise a NullPointerException at runtine trying to unbox a null value
    }
}