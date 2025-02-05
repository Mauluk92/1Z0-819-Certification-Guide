public class ValueOfValidUse {
    public static void main(String[] args){
        System.out.println("Enum: " + Season.valueOf("SPRING")); // valid use of valueOf method
    }
}

enum Season {
    SPRING, SUMMER, FALL, WINTER
}