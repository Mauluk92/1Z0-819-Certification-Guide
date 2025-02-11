import java.util.PriorityQueue;
import java.util.Queue;

public class RemoveQueueMethod {
    public static void main(String[] args){
        Queue<Integer> queue = new PriorityQueue<>(1);
        queue.remove(); // NoSuchElementException thrown because queue is empty
    }
}