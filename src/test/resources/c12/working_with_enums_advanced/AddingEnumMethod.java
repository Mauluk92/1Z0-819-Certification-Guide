public class AddingEnumMethod {
    public static void main(String[] args){
        Season winter = Season.WINTER;
        System.out.println("The next season is : " + winter.getNextSeason());
        System.out.println("The next season is : " + winter.getNextSeason().getNextSeason());
    }
}

enum Season {
    SPRING,
    SUMNMER,
    FALL,
    WINTER;

    public Season getNextSeason(){
        for (Season season: Season.values()){
            if(3 > this.ordinal() && this.ordinal() >= 0){
                return Season.values()[this.ordinal() + 1];
            }

        }
        return Season.SPRING;
    }
}