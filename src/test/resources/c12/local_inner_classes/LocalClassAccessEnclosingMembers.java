public class LocalClassAccessEnclosingMembers {
    public static void main(String[] args){
        OuterClass outerClass = new OuterClass();
        outerClass.accessCounter();
        outerClass.accessCounter();
    }
}

class OuterClass {
    private int counter = 1;
    public void accessCounter(){
        class InnerLocalClass{

            public InnerLocalClass(){
                System.out.println("Accessing enclosing class member: " + ++counter);
            }

        }
        InnerLocalClass local = new InnerLocalClass();
    }
}