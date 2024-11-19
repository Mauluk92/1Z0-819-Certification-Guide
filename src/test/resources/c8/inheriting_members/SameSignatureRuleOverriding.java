class ParentClass {
    public void methodToBeOverriden(String name){}
}

class ChildClass extends ParentClass {
    @Override // This will not compile since we are not overriding nothing and the compiler will tell us so due to the Override annotation
    public void methodWithDifferentSignature(String name, String otherArg){}
}