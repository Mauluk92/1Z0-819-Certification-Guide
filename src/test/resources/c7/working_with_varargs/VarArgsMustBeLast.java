public class VarArgsMustBeLast {
    public static void main(String[] args){

    }
}

class ClassWithVarArgMethods {
    public void varArgMethod(String... args){} // Will compile, correct definition
    public void anotherVarArgMethod(String argument, String... args){} // This one will compile too
    public void invalidVarArgMethod(String... args, String argument){} // Will not compile, var arg must be at the end
}