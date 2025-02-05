class OuterClass {
    class InnerClass{
        private final static int COUNTER = 0; // Valid, doesn't raise a compilation error
        public static int NOT_VALID; // Will raise compilation error, not allowed
    }
}