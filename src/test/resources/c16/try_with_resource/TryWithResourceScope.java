public class TryWithResourceScope {
    public static void main(String[] args){
        try(ResourceClass res = new ResourceClass()){
            // Doing logic with resource
        }
        ResourceClass anotherRes = res; // trying to access resource outside scope. Will not compile
    }
}

class ResourceClass implements AutoCloseable {
    @Override
    public void close() {
        // No implementation required for the example
    }
}