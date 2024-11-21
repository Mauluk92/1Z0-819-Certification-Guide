class ParentClass {
    public static void methodToHide(){}
}

class ChildClass extends ParentClass {
    public void methodToHide(){} // Will not compile since hiding requires both to be static if they share the same signature
}