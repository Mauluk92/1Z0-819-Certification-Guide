class AClass {
    private final int variableInitializedMoreThanOnce;

    {this.variableInitializedMoreThanOnce = 0;}
    public AClass(){
        this.variableInitializedMoreThanOnce = 1; // Won't compile since variable is already initialized in a instance initializer block
    }
}