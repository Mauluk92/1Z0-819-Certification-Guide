public class UsingSuperInsideConstructor {
    public static void main(String[] args){
        new ChildClass();
    }
}

class ParentClass {
    public ParentClass(){
        System.out.println("CALLED PARENT CONSTRUCTOR");
    }
}

class ChildClass extends ParentClass {
    public ChildClass(){
        super(); // Calls the immediate parent constructor with the given parameter list
        System.out.println("CALLED CLASS CONSTRUCTOR");
    }
}