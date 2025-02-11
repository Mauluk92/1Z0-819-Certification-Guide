import java.util.PriorityQueue;
import java.util.Queue;

public class PollQueueMethod {
    public static void main(String[] args){
        Queue<Integer> queue = new PriorityQueue<>(1);
        queue.add(1);
        System.out.println("Invoking method poll on queue: " + queue.poll());
        System.out.println("Invoking again poll on empty queue: " + queue.poll());
    }
}