public class ValueOfInvalidUse {
    public static void main(String[] args){
        System.out.println("Enum: " + Season.valueOf("spring")); // invalid use of valueOf method
    }
}

enum Season {
    SPRING, SUMMER, FALL, WINTER
}