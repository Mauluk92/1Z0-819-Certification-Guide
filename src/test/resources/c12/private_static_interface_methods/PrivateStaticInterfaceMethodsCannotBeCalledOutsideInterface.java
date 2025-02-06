interface AnInterface {
    private static void validMethod(){}
}

class AClass implements AnInterface {
    {
        validMethod(); // Cannot be called, compilation error
    }
}