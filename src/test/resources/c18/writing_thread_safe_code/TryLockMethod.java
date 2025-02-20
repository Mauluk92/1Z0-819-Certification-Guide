import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockMethod {
    public static void main(String[] args) throws InterruptedException {
        SharedEnvironment sharedEnvironment = new SharedEnvironment();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Callable<Integer> task = () -> {
            sharedEnvironment.incrementCounter();
            return sharedEnvironment.getCounter();
        };

        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);

        executorService.shutdown();

        while(!executorService.isTerminated()){
            // waiting for termination
        }

        assert sharedEnvironment.getCounter() == 4; // Lock framework will ensure that no race condition will verify
    }
}

class SharedEnvironment {
    private int counter = 0;
    private final Lock lock = new ReentrantLock();

    public int getCounter() {
        return counter;
    }

    public void incrementCounter(){
        try{
            lock.tryLock(500L, TimeUnit.MILLISECONDS); // Trying to acquire lock for 500ms
            ++this.counter;
        }catch (InterruptedException ex){
            // Catching interrupted exception
        }finally {
            lock.unlock();
        }
    }
}