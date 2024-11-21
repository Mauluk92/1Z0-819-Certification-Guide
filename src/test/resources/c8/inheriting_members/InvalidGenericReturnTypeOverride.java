import java.util.List;

class ParentClass {
    public List<CharSequence> methodToBeOverriden() {
        return null;
    }
}

class ChildClass extends ParentClass {
    @Override // Will not compile since the generic return type is NOT covariant and the parameter DOES NOT match exactly the parent one
    public List<String> methodToBeOverriden() {
        return null;
    }
}