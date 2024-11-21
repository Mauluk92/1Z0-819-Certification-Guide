public class UnrelatedClassCast {
    public static void main(String[] args){
        Integer anIntValue = 1;
        CharSequence explicitUnrelatedCast = (CharSequence) anIntValue; // Compilation error since Integer is not compatible type with CharSequence
    }
}