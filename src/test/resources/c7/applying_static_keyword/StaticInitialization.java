public class StaticInitialization {
    public static int count = 0;
    public static final int FINAL_COUNTER;

    static {
        count++;
        FINAL_COUNTER = 0;
        System.out.println(count);
        System.out.println(FINAL_COUNTER);
    }

    public static void main(String[] args){

    }
}