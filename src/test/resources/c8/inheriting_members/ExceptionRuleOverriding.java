import java.io.IOException;

class ParentClass {
    public void methodToBeOverriden() throws IOException {}
}

class ChildClass extends ParentClass {
    @Override
    public void methodToBeOverriden() throws Exception {} // Will not compile since Exception is broader than IOException
}