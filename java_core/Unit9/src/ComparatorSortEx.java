import java.util.Arrays;
import java.util.Comparator;

public class ComparatorSortEx {
    public static void main(String[] args) {
        Integer[] values = {12,345,34,7,9,12,9};
        Arrays.sort(values, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (Integer ele:values){
            System.out.println(ele+", ");
        }
    }
}
