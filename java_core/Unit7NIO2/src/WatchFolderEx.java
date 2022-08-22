import java.io.IOException;
import java.nio.file.*;

public class WatchFolderEx {
    public static void watch(Path path){
        FileSystem fs = path.getFileSystem();
        try(WatchService service = fs.newWatchService()){
            path.register(service, StandardWatchEventKinds.ENTRY_CREATE);
            while(true){
                WatchKey key ;
                key = service.take();
                for(WatchEvent watchEvent: key.pollEvents()){
                    WatchEvent.Kind kind = watchEvent.kind();
                    if(StandardWatchEventKinds.ENTRY_CREATE == kind){
                        Object newPath = ((WatchEvent) watchEvent).context();
                        System.out.println("New path created: "+newPath);
                    }
                }
                if(!key.reset()){
                    break;
                }
                break;
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Path path = Paths.get("C:\\Nodo Training\\Unit7NIO2\\src");
        watch(path);
    }
}
