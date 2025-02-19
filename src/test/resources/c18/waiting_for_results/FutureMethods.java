import java.util.concurrent.*;

public class FutureMethods {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService service = null;
        try{
            service = Executors.newSingleThreadExecutor();

            Future<String> future = service.submit(() -> "Hello World!");

            future.isDone(); // Returns true if the task was completed, threw an exception or was cancelled
            future.isCancelled(); // Returns true if the task was cancelled before it completed normally
            future.cancel(true); // Attempts to cancel the execution of the task and returns true if it was successfully cancelled or false if it is complete
            future.get(); // Retrieves the result of a task, waiting endlessly if it is not yet available
            future.get(10L, TimeUnit.SECONDS); // Retrieves the result of a task, waiting for the specified amount of time. Throws a checked TimeoutException otherwise


        }finally {
            if(service != null){
                service.shutdown();
            }
        }
    }
}