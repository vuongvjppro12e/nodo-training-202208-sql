import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFileNIOEx {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Nodo Training\\Unit7\\src\\sample.txt");

        FileInputStream fileInput = null;
        FileChannel fileChannel = null;

        try{
            fileInput = new FileInputStream(file);
            fileChannel = fileInput.getChannel();

            Long size = fileChannel.size();
            ByteBuffer buff = ByteBuffer.allocate(Math.toIntExact(size));
            fileChannel.read(buff);
            buff.rewind();
            System.out.println(new String(buff.array(),"utf8"));
        }finally {
            if(fileChannel != null){
                fileChannel.close();
            }if(fileInput!=null){
                fileInput.close();
            }
        }
    }
}
