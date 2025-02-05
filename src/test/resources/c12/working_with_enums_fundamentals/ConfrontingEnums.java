public class ConfrontingEnums {
    public static void main(String[] args){
        Season firstEnum = Season.SPRING;
        boolean isEqual = firstEnum == Season.WINTER; // Valid, since they are like constants
        Season.WINTER.equals(firstEnum); // Equally valid, since they are reference types
    }
}

enum Season {
    SPRING, SUMNMER, FALL, WINTER
}
