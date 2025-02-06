interface AnInterface{
    static void method(){}
}

class ImplementingClass implements AnInterface {
    {
        AnInterface.method(); // Will work, with explicit reference to the interface
        this.method(); // Won't compile since method() is static and not inherited
    }
}