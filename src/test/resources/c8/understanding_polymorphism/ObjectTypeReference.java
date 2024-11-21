public class ObjectTypeReference {
    public static void main(String[] args){
        ChildClass childClass = new ChildClass();
        ParentClass parentClass = childClass;
        String surname = parentClass.surname; // Won't compile since this reference doesn't allow access to childClass property
    }
}

class ParentClass {
    public String name = "NAME";
}

class ChildClass extends ParentClass {
    public String surname = "SURNAME";
}