import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(() -> System.out.println("Hello World 1!"));
        service.submit(() -> System.out.println("Hello World 2!"));
        service.submit(() -> System.out.println("Hello World 3!"));
        service.shutdown();

    }
}