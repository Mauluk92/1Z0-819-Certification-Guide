@FunctionalInterface // valid, since it has a single abstract method
interface ValidFunctionalInterface {
    void method();
}

@FunctionalInterface // not valid, does not declare a SAM
interface NonFunctionalInterface {
    void method();
    void anotherMethod();
}