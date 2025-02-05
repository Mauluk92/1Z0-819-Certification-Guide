class ClassThatWontCompile {
    public final abstract invalidMethod(); // Won't compile, final is not compatible with abstract modifier
}