public class MethodAccessModifiers {
    public static void main(String[] args){
        ClassWithMethods classWithMethods = new ClassWithMethods();
        classWithMethods.methodWithDefaultAccess(); // Works, we are in the default package
        classWithMethods.methodWithPublicAccess(); // Compile, everything can invoke that method
        classWithMethods.methodWithProtectedAccess(); // Compile, the main class is in the same package
        classWithMethods.invokePrivateMethodFromInsideClass(); // Private method is invoked from within the class itself through a public method
    }
}

class ClassWithMethods{
    // Method can be called only from classes inside the same package
    void methodWithDefaultAccess(){
        System.out.println("Inside method with package-private access");
    }
    // This is the maximal level of exposure, all classes in application code can invoke this method
    public void methodWithPublicAccess(){
        System.out.println("Inside method with public access");
    }

    // Method can be called from classes in the same package or subclasses
    protected void methodWithProtectedAccess(){
        System.out.println("Inside method with protected access");
    }

    // Can only be called inside the same class
    private void methodWithPrivateAccess(){
        System.out.println("Inside method with private access");
    }

    public void invokePrivateMethodFromInsideClass(){
        methodWithPrivateAccess();
    }
}