import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class SubmittingTask {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        // List of different methods in the ExecutorService!
        try {
            service = Executors.newSingleThreadExecutor();
            service.execute(() -> System.out.println("Executing Runnable"));
            Future<String> future = service.submit(() ->  "Hello World!");
            Future<String> futureWithSubmit = service.submit(() -> "Hello World!");
            Collection<Callable<String>> collection = List.of(() -> "Hello World!");
            List<Future<String>> futures = service.invokeAll(collection);
            String string = service.invokeAny(collection);
        }finally {
            if(service != null) {
                service.shutdown();
            }
        }
    }
}