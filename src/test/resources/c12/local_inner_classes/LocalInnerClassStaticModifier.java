class OuterClass {
    public void methodWithStaticLocalClass(){
        static class InnerClass{} // Will not compile since local inner class cannot be declared static
    }
}