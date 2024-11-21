import java.util.List;

class ParentClass {
    public void methodToBeOverriden(List<Object> args){}
}

class ChildClass extends ParentClass {
    @Override
    public void methodToBeOverriden(List<Object> args) {} // Will compile since we match the type signature
}