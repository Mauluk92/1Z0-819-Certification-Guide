import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class AddQueueMethod {
    public static void main(String[] args){
        Queue<Integer> queue = new ArrayBlockingQueue<>(1);
        System.out.println("Adding element 1 to queue: " + queue.add(1));
        System.out.println("Adding another element to queue " + queue.add(1)); // Throws IllegalStateException since the capacity is only one element
    }
}