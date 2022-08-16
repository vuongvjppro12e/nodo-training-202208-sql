import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class LinkedList2 {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>(Arrays.asList(args));
        int i = 0;
        list.forEach(value -> {
            System.out.println(value);
        });
    }
}
