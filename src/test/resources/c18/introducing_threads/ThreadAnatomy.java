import java.util.List;

public class ThreadAnatomy {
    public static void main(String[] args){
        ToySharedMemory toySharedMemory = new ToySharedMemory();
        toySharedMemory.setData(0); // Initializing memory

        ToyTask toyTask = () -> toySharedMemory.setData(1 + toySharedMemory.getData()); // Creating a task

        List<ToyTask> toyTaskList = List.of(toyTask); // List of tasks

        ToyThread firstThread = new ToyThread(toySharedMemory, toyTaskList); // Initializing threads
        ToyThread secondThread = new ToyThread(toySharedMemory, toyTaskList); // Initializing threads

        ToyProcess toyProcess = new ToyProcess(toySharedMemory, List.of(firstThread, secondThread));

        toyProcess.start(); // Starting the toy process with shared memory

        System.out.println("Final state of memory: " + toySharedMemory.getData());


    }
}

class ToyProcess {

    // Each process may have one or more thread and has a memory shared
    // by all threads

    private final ToySharedMemory toySharedMemory;
    private final List<ToyThread> toyThreadList;

    public ToyProcess(ToySharedMemory memory, List<ToyThread> toyThreadList){
        this.toySharedMemory = memory;
        this.toyThreadList = toyThreadList;
    }

    public void start(){
        System.out.println("Starting a process!");
        toyThreadList.parallelStream().forEach(ToyThread::start);
        System.out.println("Exiting a process!");
    }
}

class ToyThread {

    // Each thread has access to the same memory data shared by all threads

    private final List<ToyTask> toyTaskList;
    private final ToySharedMemory toySharedMemory;

    public ToyThread(ToySharedMemory memory, List<ToyTask> list){
        this.toyTaskList = list;
        this.toySharedMemory = memory;
    }

    public void start(){
        System.out.println("Executing a thread");
        this.toyTaskList.parallelStream().forEach(ToyTask::execute);
        System.out.println("Exiting a thread");
    }

}

class ToySharedMemory {

    // Memory should be accessed by all threads

    private Integer data;

    public Integer getData() {
        System.out.println("Accessing data from memory!");
        return data;
    }
    public void setData(Integer data) {
        System.out.println("Modifying shared memory!");
        this.data = data;
    }
}

@FunctionalInterface
interface ToyTask {

    // The task is the smallest unit of work that can be completed by a thread
    void execute();
}