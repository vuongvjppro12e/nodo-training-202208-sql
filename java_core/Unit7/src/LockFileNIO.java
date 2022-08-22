import java.awt.*;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockFileNIO {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Nodo Training\\Unit7\\src\\sample.txt");
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        FileChannel channel = raf.getChannel();
        Long value = null;
        FileLock lock = channel.tryLock(0,Long.SIZE,false);
        Desktop.getDesktop().edit(file);
        Thread.sleep(15*1000);
        lock.release();
    }
}
