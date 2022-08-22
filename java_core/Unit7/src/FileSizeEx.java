import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class FileSizeEx {
    private static long getSize(File file){
        if(file.isFile() == true){
            return file.length();
        }
        AtomicLong length = null;
        Arrays.stream(file.list()).forEach(f ->{
            length.getAndSet(length.longValue()+ (!file.isFile()? getSize(file) : file.length()));
        });
        return length.longValue();
    }

    public static void main(String[] args) {
        File file = new File("C:\\Nodo Training\\Unit7\\src\\FileSizeEx.java");
        System.out.println("Size: "+getSize(file)/(1024*1024) + "mb");
    }
}
