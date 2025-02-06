class OuterClass {
    public void notValid(){

        int counter = 0; // Not effectively finale
        class InnerClass {
            public void increaseCounter(){
                counter++; // Invalid, not effectively final
            }
        }
    }
}