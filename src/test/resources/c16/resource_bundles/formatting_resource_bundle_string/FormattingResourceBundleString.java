import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class FormattingResourceBundleString {
    public static void main(String[] args){
        Locale locale = Locale.US;
        var rb = ResourceBundle.getBundle("Hello", locale);
        String format = rb.getString("hello");

        System.out.println(MessageFormat.format(format, "World!")); // Formatting the resource bundle string with variables
    }
}