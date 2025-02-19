import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class SubmittingTaskCollections {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        ExecutorService service = null;
        try{
            service = Executors.newSingleThreadExecutor();
            Collection<Callable<String>> tasks = List.of(() -> "Hello World!", () -> "Bye!");

            List<Future<String>> futures = service.invokeAll(tasks); // Will wait indefinitely and synchronously
            for (Future<String> future : futures){
                System.out.println(future.get());
            }
            System.out.println(service.invokeAny(tasks)); // Will cancel other tasks once one is finished and returns
        }finally {
            if(service != null){
                service.shutdown();
            }
        }
        System.out.println("Finished!");
    }
}