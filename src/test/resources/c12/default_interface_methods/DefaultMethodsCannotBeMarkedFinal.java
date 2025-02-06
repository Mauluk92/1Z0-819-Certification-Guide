interface AnInterface {
    default final void method(){} // Won't compile, will raise a compilation error due to the final modifier
}