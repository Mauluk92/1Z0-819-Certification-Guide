public class AutoClosableInterface {
    public static void main(String[] args){
        try(ResourceWithAutoClosable resValid = new ResourceWithAutoClosable();
            ResourceWithoutAutoClosable resInvalid = new ResourceWithoutAutoClosable()){} // Will not compile due to the second resource which does not implement AutoClosable
    }
}

class ResourceWithoutAutoClosable {}

class ResourceWithAutoClosable implements AutoCloseable{
    @Override
    public void close() throws Exception {
        // Valid resource with try with resource
    }
}