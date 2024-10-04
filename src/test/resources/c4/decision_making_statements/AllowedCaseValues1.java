public class AllowedCaseValues1 {
    public static void main(String[] args){
        int value = 5;
        final int acceptableCaseValue = 3;
        int unacceptableCaseValue = 3;
        switch (value){
            case acceptableCaseValue: // Will compile since it is final and known at compile time
            case unacceptableCaseValue: // Will not compile since it is not final
        }
    }
}