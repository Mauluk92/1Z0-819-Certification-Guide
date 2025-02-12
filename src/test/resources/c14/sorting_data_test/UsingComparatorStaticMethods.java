import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UsingComparatorStaticMethods {
    public static void main(String[] args){

        Comparator<ToCompareClass> comparatorName = Comparator
                .comparing(ToCompareClass::getName); // Sort by name

        Comparator<ToCompareClass> comparatorInt = Comparator
                .comparingInt(ToCompareClass::getIntegerValue); // Sort by int value

        Comparator<ToCompareClass> comparatorDouble = Comparator
                .comparingDouble(ToCompareClass::getDoubleValue); // Sort by double

        Comparator<ToCompareClass> comparatorLong = Comparator
                .comparingLong(ToCompareClass::getLongValue); // Sort by long

        Comparator<ToCompareClass> comparatorNaturalOrder = Comparator.naturalOrder(); // Natural order comparator
        Comparator<ToCompareClass> comparatorReverse = Comparator.reverseOrder(); // Reverses the natural order
    }
}

class ToCompareClass {
    private String name;
    private Integer integerValue;
    private Double doubleValue;
    private Long longValue;

    public String getName() {
        return name;
    }

    public Integer getIntegerValue() {
        return integerValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public Long getLongValue() {
        return longValue;
    }
}
