interface AnInterface {
    default static void invalidMethod(){} // Will raise a compilation error, cannot be both static and default
}