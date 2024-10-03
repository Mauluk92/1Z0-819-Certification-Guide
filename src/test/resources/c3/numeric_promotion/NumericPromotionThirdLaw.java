public class NumericPromotionThirdLaw {
    public static void main(String[] args){
        short firstShortValue = 1;
        short secondShortValue = 2;

        int result = firstShortValue + secondShortValue; // Will compile
        short resultThatWontCompile = firstShortValue + secondShortValue; // Won't compile because both are being promoted to int
    }
}