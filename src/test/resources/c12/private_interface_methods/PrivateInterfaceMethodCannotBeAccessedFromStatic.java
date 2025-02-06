interface AnInterface {
    private void methodValid(){}
    static void methodWithInvalidCall(){
        methodValid(); // Won't compile, cannot be accessed from static members
    }
}