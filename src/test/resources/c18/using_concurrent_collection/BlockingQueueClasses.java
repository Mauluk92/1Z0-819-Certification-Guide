import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueClasses {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        System.out.println(queue.offer(1, 1L, TimeUnit.SECONDS)); // Will complete the operation within the given timeframe or will return false!
        System.out.println(queue.poll(1L, TimeUnit.SECONDS)); // Same! will return false if operation is not completed within the given timeframe.
    }
}