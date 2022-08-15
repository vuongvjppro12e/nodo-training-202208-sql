package Unit1;

public class StringExample4 {
    public static void main(String[] args) {
        String text = "say hello to everyone";
        System.out.println("leght of text is "+text.length());

        int i = 0;
        while (
                i<text.length()
        ){
            char c = text.charAt(i);
            if(c == '3'){
                i++;
                continue;
            }
            System.out.println("character at "+i+"is"+c);
            i++;
        }
    }
}
