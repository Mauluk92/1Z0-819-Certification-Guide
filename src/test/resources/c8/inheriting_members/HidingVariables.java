public class HidingVariables {
    public static void main(String[] args){
        ChildClass childClass = new ChildClass();
        System.out.println("Acessing instance variable from ChildClass reference: " + childClass.instanceVariable);
        ParentClass parentClass = childClass;
        System.out.println("Accessing instance variable from ParentClass reference with same name and hidden: " + parentClass.instanceVariable);
    }
}

class ParentClass {
    public String instanceVariable = "PARENT_INSTANCE_VARIABLE";
}

class ChildClass extends ParentClass {
    public String instanceVariable = "CHILD_INSTANCE_VARIABLE";
}