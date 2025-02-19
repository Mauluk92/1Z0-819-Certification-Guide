import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedBlock {
    public static void main(String[] args) throws InterruptedException {
        SharedEnvironment sharedEnvironment = new SharedEnvironment();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Runnable task = () -> {
            sharedEnvironment.setCounter(sharedEnvironment.getCounter() + 1);
        };

        executorService.execute(task);
        executorService.execute(task);
        executorService.execute(task);
        executorService.execute(task);

        executorService.shutdown();
        while(!executorService.isTerminated()){
            // Awaiting for termination
        }

        assert sharedEnvironment.getCounter() == 4; // Correct since each thread will execute only once in synchronized blocks!
    }
}

class SharedEnvironment {
    private int counter = 0;

    public synchronized int getCounter() {
        return counter;
    }

    public synchronized void setCounter(int counter) {
        this.counter = counter;
    }
}