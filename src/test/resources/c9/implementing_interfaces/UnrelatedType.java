public class UnrelatedType {
    public static void main(String[] args){
        AnInterface anInterfaceVar = new RelatedType();
        UnrelatedTypeWithInterface unrelatedType = (UnrelatedTypeWithInterface) anInterfaceVar; // Will produce a runtime exception due to being unrelated
    }
}

class UnrelatedTypeWithInterface {}

interface AnInterface {}

class RelatedType implements AnInterface {}