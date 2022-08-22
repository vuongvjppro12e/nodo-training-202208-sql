import com.sun.source.tree.ContinueTree;

import java.io.IOException;
import java.nio.file.*;

public class FileVisitorEx {
    public static class PrintFiles extends SimpleFileVisitor<Path>{

        public FileVisitResult visitFile(Path path)  {
            System.out.println(path+"is file" );
            return FileVisitResult.CONTINUE;
        }
        public FileVisitResult postVisitDirectory() {
            System.out.println("is Directory");
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Nodo Training\\Unit7\\src");
        Files.walkFileTree(path,new PrintFiles());
    }
}
