public class MultipleResourcesRule {
    public static void main(String[] args){
        try(ResourceWithAutoClosable resFirst = new ResourceWithAutoClosable();
        ResourceWithAutoClosable resSecond = new ResourceWithAutoClosable()){}
    }
}

class ResourceWithAutoClosable implements AutoCloseable {
    private static int counter = 0;
    private final int instanceCounter;

    public ResourceWithAutoClosable(){
        System.out.println("Opening resource number " + ++counter);
        this.instanceCounter = counter;
    }

    @Override
    public void close() {
        System.out.println("Closing resource number: " + this.instanceCounter);
    }
}