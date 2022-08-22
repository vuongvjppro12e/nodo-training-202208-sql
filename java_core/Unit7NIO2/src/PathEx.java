

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class PathEx {
    public static void main(String[] args) {
//        ex1();
//        ex2();
    }

     static void ex1(){
        Path path = Path.of("C:\\Temp");
        System.out.println("this is" + (Files.isDirectory(path)?"file":"foler")+" !");
        System.out.println(Files.exists(path));
    }
    static void ex2(){
       Path path = Paths.get("C:\\Nodo Training\\Unit7\\src");
        Path path2 = path.resolve("vuongct.txt");
        Charset charset = Charset.forName("utf-8");
        try (Reader reader = Files.newBufferedReader(path2,charset)){
            String line;
            line = String.valueOf(reader.read());
            System.out.println(line);
        }catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
