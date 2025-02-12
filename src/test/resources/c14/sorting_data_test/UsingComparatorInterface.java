import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UsingComparatorInterface {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("ABC");
        list.add("A");
        list.add("AB");
        System.out.println("Initial list of strings non sorted: " + list);
        // We can use the StringLengthComparator to sort strings according to their size
        Collections.sort(list, new StringLengthComparator());
        System.out.println("Final list of strings after sorting: " + list);
    }
}

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if(o1.length() == o2.length()){
            return 0;
        } else if (o1.length() > o2.length()) {
            return 1;
        }else{
            return -1;
        }
    }
}