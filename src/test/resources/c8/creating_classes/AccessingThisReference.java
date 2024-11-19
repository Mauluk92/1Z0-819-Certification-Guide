public class AccessingThisReference {
    public static void main(String[] args){
        AClass obj = new AClass();
        System.out.println("Accessing the variable value of the class: " + obj.getName());
    }
}

class AClass {
    private String name;

    public AClass(){
        String name = "VARIABLE";
        this.name = name; // Accessing the implicit instance variable inside constructor
    }

    public String getName(){
        return name;
    }
}