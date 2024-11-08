import java.lang.reflect.Method;

public class EveryClassIsObject {
    public static void main(String[] args){
        AnotherClass anotherClass = new AnotherClass();
        System.out.println("Is AnotherClass instance of Object ? " + (anotherClass instanceof Object));
        Method[] methods = anotherClass.getClass().getMethods();
        System.out.println("Looping through the methods of AnotherClass instance:...");
        for (Method method : methods){
            if(method.getName().equals("toString")){
                System.out.println("AnotherClass has toString method!");
            } else if (method.getName().equals("equals")) {
                System.out.println("AnotherClass has equals method!");
            }
        }
    }
}

class AnotherClass {}