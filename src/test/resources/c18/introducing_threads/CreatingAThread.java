public class CreatingAThread {
    public static void main(String[] args){
        Thread thread = new Thread(() -> System.out.println("Running a thread! Hello!"));
        thread.start();
    }
}