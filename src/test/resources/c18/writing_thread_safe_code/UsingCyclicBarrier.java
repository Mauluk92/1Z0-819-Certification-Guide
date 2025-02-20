import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UsingCyclicBarrier {
    public static void main(String[] args) throws InterruptedException {
        SharedEnvironment sharedEnvironmentFirst = new SharedEnvironment();
        SharedEnvironment sharedEnvironmentSecond = new SharedEnvironment();
        CyclicBarrier cyclicBarrierFirst = new CyclicBarrier(4);
        CyclicBarrier cyclicBarrierSecond = new CyclicBarrier(4);
        CyclicBarrier cyclicBarrierEndFirst = new CyclicBarrier(4);
        CyclicBarrier cyclicBarrierEndSecond = new CyclicBarrier(4);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Callable<Integer> taskFirst = () -> {
            System.out.println("Incrementing counter on first object!");
            cyclicBarrierFirst.await();
            sharedEnvironmentFirst.incrementCounter();
            cyclicBarrierEndFirst.await();
            System.out.println("Finished first object!");
            return sharedEnvironmentFirst.getCounter();
        };

        Callable<Integer> taskSecond = () -> {
            System.out.println("Incrementing counter on second object!");
            cyclicBarrierSecond.await();
            sharedEnvironmentSecond.incrementCounter();
            cyclicBarrierEndSecond.await();
            System.out.println("Finished second object!");
            return sharedEnvironmentSecond.getCounter();
        };

        executorService.submit(taskFirst);
        executorService.submit(taskFirst);
        executorService.submit(taskFirst);
        executorService.submit(taskFirst);

        executorService.submit(taskSecond);
        executorService.submit(taskSecond);
        executorService.submit(taskSecond);
        executorService.submit(taskSecond);

        executorService.shutdown();

        while(!executorService.isTerminated()){
            // waiting for termination
        }

        assert sharedEnvironmentFirst.getCounter() == 4;
        assert sharedEnvironmentSecond.getCounter() == 4;
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
            lock.lock();
            ++this.counter;
        }finally {
            lock.unlock();
        }
    }
}