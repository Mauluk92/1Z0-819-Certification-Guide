@interface MarkerAnnotation {
    String value(); // This can be optional
    String optionalValue() default ""; // If this was required we couldn't use the shorthand form
}
@MarkerAnnotation("This is a value element content!")
class MarkedClass {}