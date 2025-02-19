import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduleWithFixedDelay {
    public static void main(String[] args){
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ScheduledFuture<?> scheduledFuture = service.scheduleWithFixedDelay(() -> {
            System.out.println("Hello World!");
            int value = atomicInteger.getAndIncrement();
            if(value > 2){
                service.shutdown();
            }

        }, 0L, 1000L, TimeUnit.MILLISECONDS);
    }
}