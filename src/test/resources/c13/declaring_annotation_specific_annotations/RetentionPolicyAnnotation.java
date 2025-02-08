import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@interface SourceAnnotation {
    // Used only in the source file, discarded at runtime
}

@Retention(RetentionPolicy.CLASS)
@interface ClassAnnotation {
    // Stored in .class file but discarded at runtime
    // DEFAULT BEHAVIOUR OF COMPILER
}

@Retention(RetentionPolicy.RUNTIME)
@interface RuntimeAnnotation {
    // Stored in .class file and available at runtime
}