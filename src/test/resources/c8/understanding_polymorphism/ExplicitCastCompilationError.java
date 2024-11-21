public class ExplicitCastCompilationError {
    public static void main(String[] args){
        AClass objAClass = new AClass();
        Object objAsObject = objAClass;
        AClass compilationError = objAsObject; // Will not compile since an implicit cast will not work with a subtype
    }
}

class AClass {}