public class InvalidOverloadedMethods {
    public void notValid(int integerValue){}
    public int notValid(int integerValue){ // won't compile since it has already been defined a method of the same signature
        return integerValue;
    }
}