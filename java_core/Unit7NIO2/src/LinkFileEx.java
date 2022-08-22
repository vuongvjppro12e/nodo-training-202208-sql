import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LinkFileEx {
    public static void main(String[] args) {
        Path source = Paths.get("C:\\Nodo Training\\Unit7NIO2\\src\\vuongct.txt");
        Path target = Paths.get("C:\\Nodo Training\\Unit7NIO2\\src\\vuongct2.txt");
        Charset charset = Charset.forName("utf8");
        try(BufferedWriter writer = Files.newBufferedWriter(source,charset)) {
            writer.write("Java NIO 2 example \r\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(BufferedReader reader = Files.newBufferedReader(target,charset)){
            String line = null;
            while((line == reader.readLine())){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
