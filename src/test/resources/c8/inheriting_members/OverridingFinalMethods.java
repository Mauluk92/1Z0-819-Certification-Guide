class ParentClass{
    public final void methodToBeOverriden(){}
}

class ChildClass extends ParentClass {
    @Override
    public void methodToBeOverriden(){} // Will not compile since the parent class method is final and cannot be redefined in child class
}