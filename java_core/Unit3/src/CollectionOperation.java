import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class CollectionOperation {
    public static void main(String[] args) {
        ArrayList listOfInterger = new ArrayList<>(Arrays.asList(4,7,1,3,8,9,2,6,10));
        Comparator<Integer>comparator = Integer::compare;
        Collections.sort(listOfInterger,comparator);
        System.out.println("");
    }
}
