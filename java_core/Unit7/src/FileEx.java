import java.io.File;

public class FileEx {
    public static void main(String[] args) {
        File file = new File("C:\\Nodo Training\\Unit7\\src");
//        if(file.isFile() == true){
//            System.out.println("This is folder!");
//        }else{
//            System.out.println("This is file");
//        }

        System.out.println("This is "+((file.isFile()? "file" : "folder")));

        System.out.println(file.getName()+" : "+file.length() + "bytes");
    }
}
