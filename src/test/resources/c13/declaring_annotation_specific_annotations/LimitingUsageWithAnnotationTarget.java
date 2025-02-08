import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@interface TypeAnnotation{
    // This annotation can only be applied to classes, interfaces, enums and annotation
}
@Target(ElementType.FIELD)
@interface FieldAnnotation{
    // This annotation can only be applied to instance and static variables
}

@Target(ElementType.METHOD)
@interface MethodAnnotation {
    // This annotation can only be applied to method declarations
}

@Target(ElementType.PARAMETER)
@interface ParameterAnnotation {
    // This annotation can only be applied to constructor, method and lambda parameters
}

@Target(ElementType.CONSTRUCTOR)
@interface ConstructorAnnotation {
    // This annotation can only be applied to constructor declarations
}

@Target(ElementType.LOCAL_VARIABLE)
@interface LocalVariableAnnotation {
    // This annotation can only be applied to local variables
}

@Target(ElementType.PACKAGE)
@interface PackageAnnotation {
    // This annotation can only be applied to packages info file
}

@Target(ElementType.TYPE_PARAMETER)
@interface TypeParameterAnnotation {
    // This annotation can only be applied to parametrized types and generic declarations
}

@Target(ElementType.TYPE_USE)
@interface TypeUseAnnotation {
    // This annotation can only be applied to use of types, such as cast expressions
}

@Target(ElementType.MODULE)
@interface ModuleAnnotation {
    // this annotation can only be appliedo to module-info files
}