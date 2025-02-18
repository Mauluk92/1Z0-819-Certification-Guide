import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcurrencyExample {
    public static void main(String[] args){
        ToyScheduler toyScheduler = new ToyScheduler();
        toyScheduler.start();
    }
}

class ToyScheduler {

    private final static Map<Integer, Integer> currentStateThreadMap = new HashMap<>();
    private final List<ToyThread> toyThreadList = new ArrayList<>();

    public ToyScheduler(){
        currentStateThreadMap.put(0, 0);
        currentStateThreadMap.put(1, 0);

        ToyThread toyThread1 = () -> {
            if(currentStateThreadMap.get(0) == 0){
                System.out.println("Executing first subtask in Thread 0");
                currentStateThreadMap.put(0, 1);
            } else if (currentStateThreadMap.get(0) == 1) {
                System.out.println("Executing last subtask in Thread 0 ");
                currentStateThreadMap.put(0, 2);
            }else{
                System.out.println("Completed thread execution 0!");
                currentStateThreadMap.put(0, 3);
            }
        };

        ToyThread toyThread2 = () -> {
            if(currentStateThreadMap.get(1) == 0){
                System.out.println("Executing first subtask in Thread 1");
                currentStateThreadMap.put(1, 1);
            } else if (currentStateThreadMap.get(1) == 1) {
                System.out.println("Executing last subtask in Thread 1");
                currentStateThreadMap.put(1, 2);
            }else {
                System.out.println("Completed thread execution 1!");
                currentStateThreadMap.put(1, 3);
            }
        };

        this.toyThreadList.addAll(List.of(toyThread1, toyThread2));

    }

    public void start(){
        int counter = 0;
        while(currentStateThreadMap.get(0) < 2 && currentStateThreadMap.get(1) < 2){
            System.out.println("Cycle number " + counter + " started!");
            toyThreadList.forEach(ToyThread::execute);
            System.out.println("Cycle number " + counter + " finished!");
            ++counter;
        }
        System.out.println("Executed all tasks!");
    }

}

interface ToyThread {
    void execute();
}