import java.util.PriorityQueue;
import java.util.Queue;

public class PeekQueueMethod {
    public static void main(String[] args){
        Queue<Integer> queue = new PriorityQueue<>(1);
        System.out.println("Invoking peek on queue to get the next element: " + queue.peek()); // Returns null because queue is empty
        System.out.println("Adding an element on queue: " + queue.add(1)); // Adding  an element
        System.out.println("Invoking peek on queue to get the next element: " + queue.peek()); // Invoking peek will return the element added
        System.out.println("Invoking peek again on queue to get the next element (same element as before) : " + queue.peek()); // Invoking again will produce the same result
    }
}