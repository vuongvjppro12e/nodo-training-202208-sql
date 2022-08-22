import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FIleOutPut {
    public static void main(String[] args) throws IOException {
        File file = new File("C:" + File.separator + "Nodo Training" + File.separator + "vuongpro.txt");
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            String bytes = ("vuong nee!!");
            outputStream.write(bytes.getBytes());
        } finally {
            if(outputStream !=null){
                outputStream.close();
            }
        }
        FileInputStream inputStream = null;
        try{
            inputStream = new FileInputStream(file);

            byte[] bytes = new byte[4*1024];
            int read = -1;
            StringBuilder builder = new StringBuilder();
            while((read = inputStream.read(bytes)) != -1){
                builder.append(new String(bytes,0,read));
            }
            System.out.println("[ "+builder+" ]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
