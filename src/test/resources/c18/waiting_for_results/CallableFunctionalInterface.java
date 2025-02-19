import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFunctionalInterface {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = null;
        try{
            service = Executors.newSingleThreadExecutor();
            Future<String> callableResult = service.submit(() -> "Hello World!");
            System.out.println(callableResult.get());
        } finally {
            if(service != null){
                service.shutdown();
            }
        }

    }
}