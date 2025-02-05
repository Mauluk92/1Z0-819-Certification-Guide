public class InstantiationStaticInnerClass {
    public static void main(String[] args){
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
        System.out.println("Inner counter is equal to " + staticInnerClass.innerCounter);
    }
}

class OuterClass{

    static class StaticInnerClass {
        public static int innerCounter = 0;

    }
}