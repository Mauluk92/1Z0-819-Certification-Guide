class OuterClass {
    interface ToBeImplemented{}
    ToBeImplemented variable = new ToBeImplemented() {};

    public void useClass(ToBeImplemented toBeImplemented){

    }

    public void usePreviousMethod(){
        useClass(new ToBeImplemented() {});
    }
}