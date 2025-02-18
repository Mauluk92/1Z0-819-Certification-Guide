import java.util.Properties;

public class PropertiesClass {
    public static void main(String[] args){
        Properties props = new Properties();
        props.setProperty("aProperty", "aValue");

        System.out.println(props.getProperty("aProperty"));
        System.out.println(props.getProperty("nonExistentProperty", "defaultValue"));
    }
}