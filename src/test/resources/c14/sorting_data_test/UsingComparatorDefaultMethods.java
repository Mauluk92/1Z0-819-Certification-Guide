import java.util.Comparator;

public class UsingComparatorDefaultMethods {
    public static void main(String[] args){

        // Chaining of different comparators default methods
        // If the previous comparator returns 0, use the next comparator
        // Built with thenComparing
        Comparator<ToCompareClass> comparator = Comparator
                .comparing(ToCompareClass::getName)
                .thenComparingInt(ToCompareClass::getIntegerValue)
                .thenComparingDouble(ToCompareClass::getDoubleValue)
                .thenComparingLong(ToCompareClass::getLongValue)
                .reversed();
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