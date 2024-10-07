public class UsingWrappers {
    public static void main(String[] args){
        AnotherClass anotherClass = new AnotherClass();
        Integer nullInteger = null;
        anotherClass.unboxedValue = Integer.parseInt("1"); // Legal , Java will unbox the value into a primitive
        anotherClass.autoboxedValue = 1; // Legal , Java will autobox the value into its wrapper
        anotherClass.unboxedValue = nullInteger; // Not legal: will raise a NullPointerException since nullInteger contains a null reference and java cannot unbox a null value!
    }
}

class AnotherClass{
    int unboxedValue;
    Integer autoboxedValue;
}