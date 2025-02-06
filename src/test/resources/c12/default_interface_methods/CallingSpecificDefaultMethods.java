public class CallingSpecificDefaultMethods {
    public static void main(String[] args){
        ImplementingClass implementingClass = new ImplementingClass();
        implementingClass.commonMethods();
    }
}


interface AnInterface{
    default void commonMethods(){
        System.out.println("Calling from an interface");
    }
}

interface AnotherInterface{
    default void commonMethods(){
        System.out.println("Calling from another interface");
    }
}

class ImplementingClass implements AnInterface, AnotherInterface {
    @Override
    public void commonMethods() {
        System.out.println("Overridden method call");
        AnInterface.super.commonMethods();
        AnotherInterface.super.commonMethods();
    }
}
