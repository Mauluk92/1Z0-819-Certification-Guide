public class AddingEnumVariable {
    public static void main(String[] args){
        Season spring = Season.SPRING;
        System.out.println("Italian translation of spring is: " + spring.getItalianTranslation());
    }
}

enum Season {
    SPRING("Primavera"),
    SUMMER("Estate"),
    FALL("Autunno"),
    WINTER("Inverno");

    private final String italianTranslation;

    Season(String italianTranslation){
        this.italianTranslation = italianTranslation;
    }

    public String getItalianTranslation(){
        return this.italianTranslation;
    }

}