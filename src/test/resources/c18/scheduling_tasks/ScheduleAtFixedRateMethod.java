import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduleAtFixedRateMethod {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ScheduledFuture<?> scheduledFuture = service.scheduleAtFixedRate(() -> {
            System.out.println("Hello World!");
            int value = atomicInteger.getAndIncrement();
            if(value > 2){
                service.shutdown();
            }

        }, 0L, 1000L, TimeUnit.MILLISECONDS);

    }
}