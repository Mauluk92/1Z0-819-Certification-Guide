public class AssertionGoodPractice {
    public static void main(String[] args){
        int x = 10;
        assert ++x < 4; // Not a good practice, altering state and outcome
    }
}