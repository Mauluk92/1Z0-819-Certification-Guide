import java.io.IOException;

class ParentClass {
    public void exceptionThrower() throws Exception {}
}

class ValidChildClass extends ParentClass {
    public void exceptionThrower() throws IOException { // Will compile since IOException is more specific than Exception

    }
}