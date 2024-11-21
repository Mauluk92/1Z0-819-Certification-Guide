class ParentClass {
    private void methodToBeRedefined(){}
}

class ChildClass extends ParentClass {
    private int methodToBeRedefined(){
        return 0;
    } // Will compile since it is its own version of the method but it is not overriden
}