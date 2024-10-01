package it.mauluk92.java.testutils.extension;

import it.mauluk92.java.testutils.JavaFacade;
import it.mauluk92.java.testutils.extension.annotation.CompileClasses;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

@Order(1)
public class JavaCompilerExtension implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(Integer.class) && parameterContext.isAnnotated(CompileClasses.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext context) throws ParameterResolutionException {
    try {
        String tempDirectory = context.getStore(ExtensionContext.Namespace.GLOBAL).get("outputDir", String.class);
        if (parameterContext.isAnnotated(CompileClasses.class)) {
            CompileClasses annotation = parameterContext.getParameter().getAnnotation(CompileClasses.class);
            String classPath = annotation.classPath().isEmpty() ? tempDirectory.toString() : new ClassPathResource(annotation.classPath()).getFile().getAbsolutePath();
            String sourcePath = annotation.sourcePath().isEmpty() ? tempDirectory.toString() : new ClassPathResource(annotation.sourcePath()).getFile().getAbsolutePath();
            String[] classes = annotation.classesToCompile();
            classes = Arrays.stream(classes).map(Paths::get).map(Object::toString).toArray(String[]::new);
            return JavaFacade.compile(tempDirectory.toString(), classPath, sourcePath, classes);
        }

    }catch (IOException exception){
        throw new ParameterResolutionException("Could not locate a path", exception);
    }
        return -1;
    }
}
