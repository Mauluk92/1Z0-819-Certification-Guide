class WrongUsageDefaultClass {
    default void invalidMethod(){} // Won't compile since default can be used only inside interfaces
}