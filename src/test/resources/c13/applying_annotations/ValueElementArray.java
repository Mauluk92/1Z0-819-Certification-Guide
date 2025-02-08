@interface MarkerAnnotation {
    String[] value();
}

@MarkerAnnotation(value="Shorthand for a single element value")
class AClass{}
@MarkerAnnotation("Shorthand for a single element value")
class BClass{}
@MarkerAnnotation(value = {"Complete form without shorthand"})
class CClass{}
@MarkerAnnotation({"Complete form with a shorthand notation"})
class DClass{}