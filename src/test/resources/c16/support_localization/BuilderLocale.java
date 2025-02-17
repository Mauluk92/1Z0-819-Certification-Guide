import java.util.Locale;

public class BuilderLocale {
    public static void main(String[] args){
        Locale locale1 = new Locale.Builder()
                .setLanguage("en")
                .setRegion("US")
                .build();

        Locale locale2 = new Locale.Builder()
                .setRegion("US")
                .setLanguage("en")
                .build();

        System.out.println(locale1);
        System.out.println(locale2);
    }
}