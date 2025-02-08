class ParentClass {
    void methodToBeOverriden(){}
}

class ChildClass extends ParentClass {
    @Override // Will not compile since this method does not override any methods from parent class
    void methodNotOverridden(){}
}