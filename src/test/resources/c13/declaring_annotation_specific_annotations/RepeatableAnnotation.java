import java.lang.annotation.Repeatable;

@Repeatable(MarkerAnnotations.class) // Required in order to make the annotation repeatable
@interface MarkerAnnotation {}

@interface MarkerAnnotations {
    MarkerAnnotation[] value(); // Required in order to make the annotation repeatable
}

@MarkerAnnotation
@MarkerAnnotation
@MarkerAnnotation
class AClass {} // Will compile