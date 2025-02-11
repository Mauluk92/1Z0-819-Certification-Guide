import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class OfferQueueMethod {
    public static void main(String[] args){
        Queue<Integer> queue = new ArrayBlockingQueue<>(1);
        System.out.println("Offering an element to the queue with capaciy of 1: " + queue.offer(1));
        System.out.println("Offering another element to the queue with capaciy of 1: " + queue.offer(1));
    }
}