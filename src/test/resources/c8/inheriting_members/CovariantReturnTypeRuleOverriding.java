class ParentClass {
    public CharSequence methodToBeOverriden(){return "Hello";}
}

class ChildClass extends ParentClass {
    @Override
    public String methodToBeOverriden() { // Will compile since String implements CharSequence and is therefore covariant
        return "Hello";
    }
}

class ChildClassThatWontCompile extends ParentClass {
    @Override
    public Object methodToBeOverriden() { // Won't compile since Object is not covariant of CharSequence (Not compatible)
        return super.methodToBeOverriden();
    }
}