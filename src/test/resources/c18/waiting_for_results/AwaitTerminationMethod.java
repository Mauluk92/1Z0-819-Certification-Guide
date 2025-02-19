import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AwaitTerminationMethod {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = null;
        try{
            service = Executors.newSingleThreadExecutor();
            service.submit(() -> System.out.println("Hello World first time!"));
            service.submit(() -> System.out.println("Hello World second time!"));
            service.submit(() -> System.out.println("Hello World third time!"));
        }finally{
            if(service != null){
                service.shutdown();
            }
        }
        if(service != null){
            service.awaitTermination(1L, TimeUnit.MINUTES);

            if(service.isTerminated()){
                System.out.println("Tasks finished!");
            }else{
                System.out.println("At least one task is still running");
            }
        }
    }
}