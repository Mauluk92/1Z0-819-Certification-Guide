import java.util.concurrent.*;

public class ConcurrencyCollectionClasses {
    public static void main(String[] args){
        System.out.println(ConcurrentHashMap.class.getName());
        System.out.println(ConcurrentLinkedQueue.class.getName());
        System.out.println(ConcurrentSkipListMap.class.getName());
        System.out.println(CopyOnWriteArrayList.class.getName());
        System.out.println(CopyOnWriteArraySet.class.getName());
        System.out.println(LinkedBlockingQueue.class.getName());
    }
}