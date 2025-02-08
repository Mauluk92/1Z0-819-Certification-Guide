@interface MarkerAnnotation {
    String validValue() default ""; // Will compile since the value provided is a non null constant expression
    String invalidValue() default new String("Non constant expression"); // Will not compile since it is not a constant expression
}