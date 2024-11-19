public class CallingTheSuperReference {
    public static void main(String[] args){
        ChildClass childClass = new ChildClass();
        childClass.invokeMethod();
        childClass.invokeMethodFromParent();
    }
}

class ParentClass {
    public void invokeMethod(){
        System.out.println("PARENT CLASS METHOD INVOKED");
    }
}

class ChildClass extends ParentClass {
    public void invokeMethod(){
        System.out.println("CHILD CLASS METHOD INVOKED");
    }
    public void invokeMethodFromParent(){
        super.invokeMethod(); // We are currently invoking the method from its parent class
    }
}