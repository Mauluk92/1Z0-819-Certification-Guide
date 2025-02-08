@FunctionalInterface // Will not compile since the interface does not enforce the SAM rule
interface NotValidFunctionalInterface {
    void firstMethod();
    void secondMethod(); // Two abstract methods not allowed in a functional interface
}
