import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class SynchronizedCollectionClasses {
    public static void main(String[] args){
        Collection<Integer> collection = new HashSet<>();

        collection.add(1);
        collection.add(2);
        collection.add(3);

        Collection<Integer> threadSafeCollection = Collections.synchronizedCollection(collection);
        synchronized (threadSafeCollection) {
            Iterator<Integer> iterator = threadSafeCollection.iterator(); // Will execute without exception since iterator is in synchronized blocks
            while(iterator.hasNext()){
                iterator.next();
            }
        }
        // Single operations (add, remove and so on) are guaranteed by a synchronized block wrapped around them
        // But iterator, stream and splititerator are not thread safe! Remember this!

        Iterator<Integer> iteratorNotSafe = threadSafeCollection.iterator();
        while(iteratorNotSafe.hasNext()){
            threadSafeCollection.remove(iteratorNotSafe.next()); // ConcurrentModificationException will be thrown since it is not in a synchronized block
        }
    }
}