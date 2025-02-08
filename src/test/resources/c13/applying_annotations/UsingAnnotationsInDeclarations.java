import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_USE, ElementType.TYPE, ElementType.TYPE_PARAMETER, ElementType.METHOD})
@interface MarkerAnnotation {}
@MarkerAnnotation
@interface MarkedAnnotation{}
@MarkerAnnotation
class MarkedClass{
    @MarkerAnnotation
    public static final int COUNTER = 1;
    @MarkerAnnotation
    private String instanceVariable;
    @MarkerAnnotation
    public MarkedClass(@MarkerAnnotation String s){

    }
    @MarkerAnnotation
    public void setString(@MarkerAnnotation String s){
        @MarkerAnnotation String b = "local variable";
        Object a = b;
        String newString = (@MarkerAnnotation String) a;
    }
}