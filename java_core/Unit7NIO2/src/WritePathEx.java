import java.io.IOException;
import java.io.Writer;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;

public class WritePathEx {
    public static void main(String[] args) {
        ex1();
    }
    static void ex1(){
        Path path = Paths.get("C:\\Nodo Training\\Unit7\\src\\vuongct2.txt");
        try(Writer writer =Files.newBufferedWriter(path,Charset.defaultCharset() ,CREATE,APPEND)) {
            writer.write("vuong nee"+"\r\n");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    static void ex2(){
//        Path path = Paths.get("C:\\Nodo Training\\Unit7\\src\\vuongct2.txt");
//        Buffer buffer = ByteBuffer.allocate(14);
//        try (FileChannel fc = FileChannel.open(path,READ,WRITE)){
//            fc.read((ByteBuffer) buffer);
//            System.out.println(buffer.array());
//            fc.position(0);
//             Byte bytes = Byte.valueOf("zon");
//             fc.write(ByteBuffer.wrap(bytes,));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
