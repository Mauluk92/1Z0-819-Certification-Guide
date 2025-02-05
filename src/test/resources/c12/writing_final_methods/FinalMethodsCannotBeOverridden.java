abstract class ParentClass {
    abstract public void methodToBeOverridden();
}

class ChildClass extends ParentClass {
    public final void methodToBeOverridden(){
        // This method is now finale
    }
}

class TerminalClass extends ChildClass {
    public void methodToBeOverridden(){} // Method cannot be overriden: compilation error
}