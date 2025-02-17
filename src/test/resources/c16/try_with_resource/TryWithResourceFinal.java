public class TryWithResourceFinal {
    public static void main(String[] args){
        final ResourceClass res = new ResourceClass(); // Final resource
        try(res){
            // Will compile
        }
        ResourceClass notFinalRes = new ResourceClass();
        try(notFinalRes){ // modifying the resource class, will not compile
            // Will not compile
        }
        notFinalRes = null; // modified here. NotFinalRes is not final or effectively final
    }
}

class ResourceClass implements AutoCloseable {
    @Override
    public void close() {
        // No implementation required
    }
}