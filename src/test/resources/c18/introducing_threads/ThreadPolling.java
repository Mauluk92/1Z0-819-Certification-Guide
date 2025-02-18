public class ThreadPolling {
    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for(int i= 0; i < 500; i++){
                ThreadPolling.counter++;
            }
        }).start();

        while(ThreadPolling.counter < 100){
            System.out.println("Not reached target!");
            Thread.sleep(1000); // 1 second: Thread sleep polling implementation
        }
        System.out.println("Reached!");
    }
}