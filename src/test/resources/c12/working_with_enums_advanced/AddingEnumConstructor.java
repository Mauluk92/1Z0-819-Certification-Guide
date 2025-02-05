public class AddingEnumConstructor {
    public static void main(String[] args){
        Season spring = Season.SPRING; // calling constructor once
        Season winter = Season.WINTER; // constructor not called
    }
}
enum Season {
    SPRING, SUMMER, FALL, WINTER;
    Season(){
        System.out.println("Inside enum constructor");
    }
}