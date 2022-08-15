package Unit1;

public class StringExample3 {
    public static void main(String[] args) {
        String text ="Absolute Value";
        byte [] bytes = text.getBytes();
        System.out.println("bytes values are");
        for (int i =0; i<bytes.length;i++){
            System.out.println((int)bytes[i]+",");
        }
    }
}
