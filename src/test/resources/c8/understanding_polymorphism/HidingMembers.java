public class HidingMembers {
    public static void main(String[] args){
        ParentClass parentClassReference = new ChildClass();
        parentClassReference.methodToBeHidden();
        ChildClass childClassReference = (ChildClass) parentClassReference;
        childClassReference.methodToBeHidden();
    }
}

class ParentClass {
    public static void methodToBeHidden(){
        System.out.println("Parent method invoked");
    }
}

class ChildClass extends ParentClass {
    public static void methodToBeHidden(){
        System.out.println("Child method invoked");
    }
}