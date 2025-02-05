public class InnerClassCanAccessPrivateOuter {
    public static void main(String[] args){
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass(); // instantiating an inner class
        innerClass.accessOuter();
    }
}

class OuterClass {
    private String outerVariable = "Outer variable";

    class InnerClass {
        public void accessOuter(){
            System.out.println("Accessing " + outerVariable);
        }
    }
}