import java.util.List;

class ParentClass {
    public void methodToBeOverloaded(List<Object> args){}
}

class ChildClass extends ParentClass {
    public void methodToBeOverloaded(List<String> args){} //Will not compile due to type erasure
}