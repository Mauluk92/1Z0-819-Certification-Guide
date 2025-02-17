import java.util.Locale;

public class ConstantsLocale {
    public static void main(String[] args){
        Locale locale = Locale.ENGLISH;
        Locale fullLocale = Locale.UK;

        System.out.println(locale); // Prints en
        System.out.println(fullLocale); // Prints en_GB
    }
}