public class EnumsInSwitchStatement {
    public static void main(String[] args){
        Season season = Season.SUMMER;
        switch (season){
            case SUMMER:{
                System.out.println("Inside SUMMER case");
                break;
            }
            default:{
                System.out.println("Default switch case");
            }
        }
    }
}

enum Season {
    SPRING, SUMMER, FALL, WINTER
}