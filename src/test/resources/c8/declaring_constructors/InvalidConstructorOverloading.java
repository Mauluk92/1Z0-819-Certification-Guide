public class InvalidConstructorOverloading {
    public InvalidConstructorOverloading(String arg){}
    protected InvalidConstructorOverloading(String otherArg){} // Will not compile. Invalid overloaded constructor
}