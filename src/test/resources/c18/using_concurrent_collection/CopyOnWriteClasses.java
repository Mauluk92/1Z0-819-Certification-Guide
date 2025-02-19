import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteClasses {
    public static void main(String[] args){
        List<Integer> numbers = new CopyOnWriteArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        Iterator<Integer> iteratorPriorToModifcation = numbers.iterator();
        numbers.add(4); // Will not modify the previous iterator since it is a CopyOnWriteArrayList!

        while(iteratorPriorToModifcation.hasNext()){
            System.out.println(iteratorPriorToModifcation.next()); // Will print all numbers except 4
        }
    }
}