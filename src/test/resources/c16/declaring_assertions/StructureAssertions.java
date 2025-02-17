public class StructureAssertions {
    public static void main(String[] args){
        int variableToCheck = 1;

        assert variableToCheck < 2; // True
        assert (variableToCheck > 2) : "Condition not met! Throwing AssertionError"; // Will produce a fatal Error
    }
}