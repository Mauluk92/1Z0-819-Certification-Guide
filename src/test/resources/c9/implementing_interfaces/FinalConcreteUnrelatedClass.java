public class FinalConcreteUnrelatedClass {
    public static void main(String[] args){
        AnInterface anInterfaceVar = new RelatedType();
        UnrelatedType unrelatedType = (UnrelatedType) anInterfaceVar; // It will not compile since it can be determined at compile time that the given class casted into is not related to that given interface reference.
    }
}

final class UnrelatedType {}

interface AnInterface {}

class RelatedType implements AnInterface {}