import java.util.concurrent.*;

public class ScheduleMethod {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService service = null;
        try {
            service = Executors.newSingleThreadScheduledExecutor();
            Callable<String> taskCallable = () -> "Hello World!";
            Runnable taskRunnable = () -> System.out.println("Yet another Hello World!");

            System.out.println(service.schedule(taskCallable, 500L, TimeUnit.MILLISECONDS).get());
            service.schedule(taskRunnable, 500L, TimeUnit.MILLISECONDS);
        }finally {
            if(service != null){
                service.shutdown();
            }
        }
    }
}