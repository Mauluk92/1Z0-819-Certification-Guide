import java.util.Locale;

public class CreatingCustomLocale {
    public static void main(String[] args){
        Locale languageLocale = new Locale("fr");
        Locale fullLocale = new Locale("hi", "IN");

        System.out.println(languageLocale);
        System.out.println(fullLocale);
    }
}