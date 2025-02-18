import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = () -> System.out.println("Running first task!");
        Runnable task2 = () -> System.out.println("Running second task!");
        Runnable task3 = () -> System.out.println("Running third task!");

        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor(); // Single thread worker. All tasks will be executed sequentially!

            service.execute(task1);
            service.execute(task2);
            service.execute(task3);

        } finally {
            if (service != null) {
                service.shutdown();
            }
        }

    }
}