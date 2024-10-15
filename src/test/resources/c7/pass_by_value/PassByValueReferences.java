public class PassByValueReferences {
    public static void main(String[] args){
        ReferenceType referenceType = new ReferenceType();
        System.out.println("Reference type counter before being incremented inside a method " + referenceType.counter);
        incrementCounterOnReferenceType(referenceType);
        System.out.println("Reference type counter after being incremented inside a method " + referenceType.counter);
    }

    public static void incrementCounterOnReferenceType(ReferenceType ref){
        ref.counter++;
    }
}

class ReferenceType {
    public int counter = 0;
}