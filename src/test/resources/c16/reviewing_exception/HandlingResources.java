public class HandlingResources {
    public static void main(String[] args){
        try(
                AutoClosableResource firstResource = new AutoClosableResource();
                AutoClosableSecondResource secondResource = new AutoClosableSecondResource()
        ){
            // Protected code!
            System.out.println("Inside protected code!");
            System.out.println("Resources are closed in reverse order of declaration!");

        } catch (Exception ex) {
            // Optional catch block!
        }finally {
            // Optional finally block!
        }
    }
}

class AutoClosableResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Closing first Resource!");
    }
}

class AutoClosableSecondResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Closing second Resource!");
    }
}
