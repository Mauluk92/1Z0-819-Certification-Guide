public class InitializingAClass {
    public static void main(String[] args){
        ChildClass childClass = new ChildClass();
    }
}


class ParentClass {
    private final static String PARENT_CONSTANT_1 = "PARENT_STATIC_VARIABLE_1";
    private final static String PARENT_CONSTANT_2;

    static {
        System.out.println("Initializing parent class...");
        System.out.println("PARENT_CONSTANT_1 value: " + PARENT_CONSTANT_1);
        System.out.println("Initializing PARENT_CONSTANT_2");
        PARENT_CONSTANT_2 = "PARENT_STATIC_VARIABLE_2";
        System.out.println("PARENT_CONSTANT_2 value is now: " + PARENT_CONSTANT_2);
        System.out.println("Ending initialization of parent class...");
    }
}

class ChildClass extends ParentClass {
    private final static String CHILD_CONSTANT_1 = "CHILD_STATIC_VARIABLE_1";
    private final static String CHILD_CONSTANT_2;

    static {
        System.out.println("Initializing child class...");
        System.out.println("CHILD_CONSTANT_1 value: " + CHILD_CONSTANT_1);
        System.out.println("Initializing CHILD_CONSTANT_2");
        CHILD_CONSTANT_2 = "CHILD_STATIC_VARIABLE_2";
        System.out.println("CHILD_CONSTANT_2 value is now: " + CHILD_CONSTANT_2);
        System.out.println("Ending initialization of child class...");
    }

}