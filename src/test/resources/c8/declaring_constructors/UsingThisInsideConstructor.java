public class UsingThisInsideConstructor {
    public static void main(String[] args){
        OverloadedConstructorClass overloadedConstructorClass = new OverloadedConstructorClass("Hello", "World");
        overloadedConstructorClass.greet();
    }
}

class OverloadedConstructorClass {
    private String name;
    private String greeting;


    public OverloadedConstructorClass(String greeting){
        this.greeting = greeting;
    }

    public OverloadedConstructorClass(String greeting, String name){
        this(greeting); // The previous constructor is invoked inside this constructor
        this.name = name;
    }

    public void greet(){
        System.out.println(greeting + " " + name + "!");
    }
}