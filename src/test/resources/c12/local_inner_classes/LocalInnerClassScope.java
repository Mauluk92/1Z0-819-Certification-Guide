public class LocalInnerClassScope {
    public static void main(String[] args){
        class LocalInnerClass {
            public int counter = 0;
        }

        LocalInnerClass innerClass = new LocalInnerClass();
        System.out.println("Accessing counter inside local inner class: " + innerClass.counter);
    }
}