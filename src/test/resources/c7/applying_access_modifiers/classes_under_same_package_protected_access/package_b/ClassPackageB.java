package package_b;

import package_a.ClassPackageA;
public class ClassPackageB extends ClassPackageA {
    public void invokingProtectedMethod(){
        protectedMethod(); // Will compile since it is a subclass
    }
}

class ClassMustNotCompile {
    public void invokingProtectedMethod() {
        ClassPackageA classPackageA = new ClassPackageA();
        classPackageA.protectedMethod(); // Won't compile since it is not a subclass and ClassPackageA is in another package
    }
}