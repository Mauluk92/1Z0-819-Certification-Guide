import java.util.Locale;
import java.util.ResourceBundle;

public class UsingResourceBundle {
    public static void main(String[] args){
        Locale locale = Locale.US;
        Locale localeFrench = Locale.FRANCE;
        var rb = ResourceBundle.getBundle("Hello", locale);
        var rbFrench = ResourceBundle.getBundle("Hello", localeFrench);

        System.out.println(rb.getString("hello"));
        System.out.println(rbFrench.getString("hello"));

    }
}