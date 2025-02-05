public class ReferenceFinalLocalVariableCanChangeItsState {
    public static void main(String[] args){
        // This wiull compile since we are not modifying the reference but the state of the object
        final ObjectReference objectReference = new ObjectReference();
        objectReference.variable = 0;
        objectReference.variable = 1;
    }
}

class ObjectReference {
    public int variable;
}