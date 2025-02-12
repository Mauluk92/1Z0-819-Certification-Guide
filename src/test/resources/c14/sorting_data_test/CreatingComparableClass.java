public class CreatingComparableClass {
    public static void main(String[] args){
        ComparableClass first = new ComparableClass("A"); // first object comes before according to lexicographic order
        ComparableClass second = new ComparableClass("B"); // second object comes after according to lexicographic order

        System.out.println("Comparing object A with B: " + first.compareTo(second)); // Prints -1, since A comes before B
    }
}

class ComparableClass implements Comparable<ComparableClass> {

    private final String comparingField;

    public ComparableClass(String field){
        this.comparingField = field;
    }

    public String getComparingField(){
        return this.comparingField;
    }

    @Override
    public int compareTo(ComparableClass o) {
        return this.comparingField.compareTo(o.getComparingField());
    }
}