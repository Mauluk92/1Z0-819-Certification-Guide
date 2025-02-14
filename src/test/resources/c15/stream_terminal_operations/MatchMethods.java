import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MatchMethods {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        Stream<Integer> anyMatchStream = list.stream();
        Stream<Integer> noneMatchStream = list.stream();
        Stream<Integer> allMatchStream = list.stream();

        System.out.println("List given: " + list);

        System.out.println("Stream contains at least one number greater than 2: " + anyMatchStream.anyMatch(integer -> integer > 2));
        System.out.println("Stream contains no number greater than 3: " + noneMatchStream.noneMatch(integer -> integer > 3));
        System.out.println("Stream contains numbers greater than 0: " + allMatchStream.allMatch(integer -> integer > 0));
    }
}