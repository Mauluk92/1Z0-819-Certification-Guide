package it.mauluk92.java.testutils.extension;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CleanUpCompileTempDirectoryCallBack implements AfterEachCallback {


    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        Path tempDir = Paths.get(context.getStore(ExtensionContext.Namespace.GLOBAL).get("outputDir", String.class));
        Files.walkFileTree(tempDir, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                if (Files.exists(dir)){
                    return FileVisitResult.CONTINUE;
                }
                return FileVisitResult.TERMINATE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.TERMINATE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.TERMINATE;
            }
        });
    }
}
