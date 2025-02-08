@interface AnnotationWithRequiredElement {
    String requiredElement();
}
@AnnotationWithRequiredElement(requiredElement = "This is a mandatory element") // This will compile since the required element is provided
class MarkedClass {}

@AnnotationWithRequiredElement // Will not compile since it requires an element, not provided
class AnotherMarkedClass {}