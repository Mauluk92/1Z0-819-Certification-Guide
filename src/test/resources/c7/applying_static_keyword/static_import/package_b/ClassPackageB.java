package package_b;

import static package_a.ClassPackageA.staticMethod;
import static package_a.ClassPackageA.CONSTANT;
public class ClassPackageB {
    public static void main(String[] args){
        System.out.println(CONSTANT);
        staticMethod();
    }
}