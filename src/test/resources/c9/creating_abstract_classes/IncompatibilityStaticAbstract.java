abstract class AbstractClass{
    public static abstract void invalidMethod(); // Will not compile because static methods can only be hidden but not overriden in child class
}