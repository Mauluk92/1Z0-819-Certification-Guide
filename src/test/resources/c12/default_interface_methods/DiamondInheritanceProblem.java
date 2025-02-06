interface AnInterface {
    default void methodWithSameSignature(){}
}

interface AnotherInterface {
    default void methodWithSameSignature(){}
}

class ImplementingClass implements AnInterface, AnotherInterface {} // compilation error, must redefine the method inhreted from both interfaces