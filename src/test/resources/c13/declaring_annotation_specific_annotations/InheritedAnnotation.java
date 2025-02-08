import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class InheritedAnnotation {
    public static void main(String[] args){
        ParentClass parentClass = new ParentClass();
        ChildClass childClass = new ChildClass();

        System.out.println("MarkerAnnotation present on parent class: " + parentClass.getClass().isAnnotationPresent(MarkerAnnotation.class));
        System.out.println("MarkerAnnotation present on child class: " + childClass.getClass().isAnnotationPresent(MarkerAnnotation.class));
    }
}

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface MarkerAnnotation {
    // This annotation will be present at runtime and will be inherited by any child class
}

@MarkerAnnotation
class ParentClass {}

class ChildClass extends ParentClass {}