package Unit1;

import java.util.Arrays;

public class StreamProgram {
    public static void main(String[] args) {
        Arrays.stream(args).forEach((String value)->{
            System.out.println("value is " +value);
        });
    }
}
