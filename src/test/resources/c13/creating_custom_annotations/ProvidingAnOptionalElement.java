@interface AnnotationWithOptionalElements {
    String requiredElement();
    String optionalElement () default "Optional value";
}

@AnnotationWithOptionalElements(requiredElement =  "This is a required element", optionalElement = "This is optional") // Will compile
class MarkedClass{}

@AnnotationWithOptionalElements(requiredElement = "This is a required element") // Will compile
class AnotherMarkedClass{}