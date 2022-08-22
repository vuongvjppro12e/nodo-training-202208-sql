import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

public class ObjectReaderExample {
    public static void main(String[] args) throws Exception{
        File folder = new File("C:\\Nodo Training\\Unit7\\src");
        ObjectInputStream input = null;
        input = new ObjectInputStream(new FileInputStream(new File(folder,"sample.txt")));
        Object obj = input.readObject();
        Method method = obj.getClass().getMethod("run",new Class[0]);
        method.invoke(obj,new Object[0]);
        input.close();
    }
}
