public class PolymorphismMethodOverriding {
    public static void main(String[] args) {
        ParentClass parentClassReference = new ChildClass();
        parentClassReference.methodToBeOverriden(); // Due to polymorphism the child version will be called
    }
}

class ParentClass {
    public void methodToBeOverriden(){
        System.out.println("Parent method called");
    }
}

class ChildClass extends ParentClass {
    @Override
    public void methodToBeOverriden() {
        System.out.println("Child method called");
    }
}