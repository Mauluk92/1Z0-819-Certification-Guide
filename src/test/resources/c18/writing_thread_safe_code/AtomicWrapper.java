import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicWrapper {
    public static void main(String[] args) throws InterruptedException {
        SharedEnvironment sharedEnvironment = new SharedEnvironment();
        sharedEnvironment.getCounter().getAndIncrement(); // Using this method to get and increment in atomic fashion an integer
        sharedEnvironment.getCounter().incrementAndGet(); // The same but reversing the order of operations!
    }
}

class SharedEnvironment {
    private final AtomicInteger counter = new AtomicInteger(0);

    public AtomicInteger getCounter() {
        return counter;
    }
}