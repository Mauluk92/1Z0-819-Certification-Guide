public class ExceptionList {
    // Valid, will compile
    public void mandatoryExceptionList() throws Exception {
        throw new Exception(); // Will compile
    }

    public void notMandatoryExceptionList(){
        try{
            throw new Exception();
        }catch(Exception exception){
            // Catching the exception will not require the exception list
        }
    }

    public void anotherNotMandatoryExceptionList(){
        throw new RuntimeException(); // Will compile since it is runtime exception!
    }

    public void willNotCompile() {
        throw new Exception(); // Invalid, will not compile , Exception must be signaled in throws list, if not RuntimeException!
    }
}