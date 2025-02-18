public class DefiningTaskWithRunnable {
    public static void main(String[] args){
        Runnable runnable = () -> System.out.println("Runnable interface implementation through lambda!");
        runnable.run();
    }
}