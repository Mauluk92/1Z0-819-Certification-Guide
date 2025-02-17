import java.util.Locale;

public class SettingDefaultLocale {
    public static void main(String[] args){
        System.out.println("Printing the default locale: " + Locale.getDefault());
        Locale locale = new Locale("en");

        Locale.setDefault(locale);
        System.out.println("Printing the new setted default: " + Locale.getDefault());
    }
}