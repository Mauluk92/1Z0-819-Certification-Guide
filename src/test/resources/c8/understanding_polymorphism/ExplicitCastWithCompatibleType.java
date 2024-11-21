public class ExplicitCastWithCompatibleType {
    public static void main(String[] args){
        AClass obj = new AClass();
        Object objImplicitCast = obj;
        AClass objExplicitCast = (AClass) objImplicitCast; // Will compile since objImplicitCast refers to a compatible type with AClass
    }
}

class AClass{}