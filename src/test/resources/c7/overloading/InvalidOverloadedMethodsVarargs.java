public class InvalidOverloadedMethodsVarargs {
    public void invalidOverloadedMethod(String... args){}
    public void invalidOverloadedMethod(String[] args){} // Won't compile since it is the same method
}