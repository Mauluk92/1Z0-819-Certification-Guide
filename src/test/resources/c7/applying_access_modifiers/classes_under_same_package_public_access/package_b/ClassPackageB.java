package package_b;

import package_a.ClassPackageA;
public class ClassPackageB {
    public void invokingPublicMethod(){
        ClassPackageA classPackageA = new ClassPackageA();
        classPackageA.publicMethod(); // Will compile since it is a public method, accessible everywhere in the code application
    }
}