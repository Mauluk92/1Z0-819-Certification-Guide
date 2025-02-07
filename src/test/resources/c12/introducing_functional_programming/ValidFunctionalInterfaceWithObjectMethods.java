@FunctionalInterface // Will compile sibnce object methods inherited do not count
interface ValidFunctionalInterface {

    void method();
    String toString();
    boolean equals(Object other);
    int hashCode();
}