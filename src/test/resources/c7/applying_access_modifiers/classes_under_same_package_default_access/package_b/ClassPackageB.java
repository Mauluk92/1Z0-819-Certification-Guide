package package_b;

import package_a.ClassPackageA;
public class ClassPackageB {
    public void invokingPackagePrivateMethod(){
        ClassPackageA classPackageA = new ClassPackageA();
        classPackageA.packagePrivateMethod(); // Does not compile since it is package-private
    }
}