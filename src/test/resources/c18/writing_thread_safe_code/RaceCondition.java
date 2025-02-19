import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        SharedEnvironment sharedEnvironment = new SharedEnvironment();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Callable<Integer> task = () -> {
            sharedEnvironment.setCounter(sharedEnvironment.getCounter() + 1);
            return sharedEnvironment.getCounter();
        };

        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);

        executorService.shutdown();

        assert sharedEnvironment.getCounter() > 2; // Will not be verified due to a race condition! Incorrect access to data. Missing updates
    }
}

class SharedEnvironment {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}