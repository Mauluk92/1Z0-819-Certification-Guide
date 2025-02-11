import java.util.PriorityQueue;
import java.util.Queue;

public class ElementQueueMethod {
    public static void main(String[] args){
        Queue<Integer> queue = new PriorityQueue<>(1);
        queue.element(); // Throws NoSuchElementException since queue is empty!
    }
}