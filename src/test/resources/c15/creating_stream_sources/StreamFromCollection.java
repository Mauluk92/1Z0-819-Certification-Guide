import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class StreamFromCollection {
    public static void main(String[] args){
        Collection<Integer> collection = new ArrayList<>();

        collection.add(1);
        collection.add(2);
        collection.add(3);

        Stream<Integer> streamFromCollection = collection.stream();

        System.out.println("Printing stream content from collection!");

        streamFromCollection.forEach(System.out::println);
    }
}