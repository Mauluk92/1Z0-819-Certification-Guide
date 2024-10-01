package it.mauluk92.java.testutils.extension.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CompileClasses {
    String[] classesToCompile();
    String classPath() default "";
    String sourcePath() default "";
}