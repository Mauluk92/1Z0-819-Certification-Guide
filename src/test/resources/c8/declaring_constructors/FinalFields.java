public class FinalFields {
    private final String initializedFinalField;
    private final String uninitializedFinalField;


    public FinalFields(){
        this.initializedFinalField = "Hello";
    } // A compilation error will occur since the second instance variable is not being initialized inside constructor
}