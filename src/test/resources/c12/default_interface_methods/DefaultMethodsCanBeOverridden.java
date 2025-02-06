interface AnInterface {
    default void methodToBeOverriden(){

    }
}

class ClassImplementingInterface implements  AnInterface {
    @Override
    public void methodToBeOverriden() {
        // Overridden method from interface
    }
}