public class CyclingThroughEnums {
    public static void main(String[] args){
        for (Season season : Season.values()){
            System.out.println(season);
        }
    }
}

enum Season {
    SPRING, SUMMER, FALL, WINTER
}