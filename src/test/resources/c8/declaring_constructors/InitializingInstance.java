public class InitializingInstance {
    public static void main(String[] args){
        ChildClass childClass = new ChildClass();
    }

}


class ParentClass {

    private final String instanceVariableParent1 = "PARENT_01";
    private final String instanceVariableParent2;

    {
        System.out.println("Entering parent first instance initialization block... ");
        System.out.println("Value of instanceVariableParent1: " + instanceVariableParent1);
        System.out.println("Initializing instanceVariableParent2");
        instanceVariableParent2 = "PARENT_02";
        System.out.println("Value of instanceVariableParent2: " + instanceVariableParent2);
        System.out.println("Exiting parent first instance initialization block... ");
    }

    private final String instanceVariableParent3 = "PARENT_03";
    private final String instanceVariableParent4;

    {
        System.out.println("Entering parent second instance initialization block... ");
        System.out.println("Value of instanceVariableParent3: " + instanceVariableParent3);
        System.out.println("Initializing instanceVariableParent4");
        instanceVariableParent4 = "PARENT_04";
        System.out.println("Value of instanceVariableParent4: " + instanceVariableParent4);
        System.out.println("Exiting parent second instance initialization block... ");
    }

    public ParentClass() {
        System.out.println("Entered parent constructor no arg... ");
        System.out.println("Exiting parent constructor no arg... ");
    }
}

class ChildClass extends ParentClass {

    private final String instanceVariableChild;

    {
        System.out.println("Entering child instance initialization block");
        System.out.println("Initializing instanceVariableChild");
        instanceVariableChild = "INSTANCE_VARIABLE";
        System.out.println("Value of instanceVariableChild: " + instanceVariableChild);
        System.out.println("Exiting child instance initialization block");
    }

    public ChildClass(){
        System.out.println("Entering child constructor no arg");
        System.out.println("Exiting child constructor no arg");
    }
}