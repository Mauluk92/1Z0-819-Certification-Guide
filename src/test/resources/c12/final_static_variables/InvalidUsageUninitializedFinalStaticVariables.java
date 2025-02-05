class AClass {
    public final static int INTEGER_VARIABLE;

    static
    {
        System.out.println(INTEGER_VARIABLE); // Will not compile since it has not been initialized
    }
}