import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShuttingDownThreadExecutor {
    public static void main(String[] args){
        ExecutorService service = null;
        try{
            service = Executors.newSingleThreadExecutor();
            System.out.println("Is shutdown: " + service.isShutdown());
            System.out.println("Is terminated: " + service.isTerminated());
        }finally{
            if(service != null) {
                service.shutdown();
                System.out.println("Is shutdown: " + service.isShutdown());
                System.out.println("Is terminated: " + service.isTerminated());
            }
        }
    }
}