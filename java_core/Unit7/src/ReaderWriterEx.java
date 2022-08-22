import java.io.File;
import java.io.FileReader;

public class ReaderWriterEx {
    public static void main(String[] args) throws Exception{

        try {
            File file = new File("C:\\Nodo Training\\Unit7\\src\\sample.txt");
            FileReader fd= new FileReader(file);
            char[] buffer= new char[4*1024];
            int read=-1;
            StringBuilder builder= new StringBuilder();
            while ((read= fd.read(buffer))!=-1){
                builder.append(buffer,0,read);
            }
            System.out.println(builder);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
