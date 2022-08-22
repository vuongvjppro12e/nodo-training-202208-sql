
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.regex.Matcher;

public class FileFinder extends  SimpleFileVisitor{
    static class Finder extends SimpleFileVisitor<Path> {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt}");

        public FileVisitResult visitFile(Path path) {
            if (matcher.matches(path.getFileName())) {
                System.out.println("found: " + path);

            }
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        Finder finder = new Finder();
        Files.walkFileTree(Path.of("C:\\Tem"), finder);
    }
}
