public class AnonymousInnerClasses {

    interface ToBeImplemented {
        void methodToImplement();
    }

    public static void main(String[] args){

        // Short example of an inner anonymous class
        ToBeImplemented implementation = new ToBeImplemented() {
            @Override
            public void methodToImplement() {
                System.out.println("Inside anonymous inner class!");
            }
        };
        implementation.methodToImplement();
    }
}