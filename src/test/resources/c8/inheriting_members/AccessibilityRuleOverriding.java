class ParentClass {
    public void methodToBeOverriden(){}
}

class ChildClass extends ParentClass {
    @Override
    protected void methodToBeOverriden(){} // This will not compile since the accessibility is narrower than the parent class
}