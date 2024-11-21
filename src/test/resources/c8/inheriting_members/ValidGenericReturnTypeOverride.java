import java.util.ArrayList;
import java.util.List;

class ParentClass {
    public List<Object> methodToBeOverriden() {
        return null;
    }
}

class ChildClass extends ParentClass {
    @Override // Will compile since the generic return type is covariant and the parameter match exactly the parent one
    public ArrayList<Object> methodToBeOverriden() {
        return null;
    }
}