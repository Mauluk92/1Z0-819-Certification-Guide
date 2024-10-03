public class NumericPromotionFirstLaw {
    public static void main(String[] args){
        int intValue = 1;
        long longValue = 2L;

        long result = intValue + longValue; // Will compile

        //This operation is equivalent to following set operations

        long promotedInt = (long) intValue;
        result = promotedInt + longValue;
    }
}