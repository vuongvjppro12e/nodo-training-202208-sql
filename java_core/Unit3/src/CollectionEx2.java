import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionEx2 {
    public static void main(String[] args) {
        List<String>list = new ArrayList<String>();
        Collections.addAll(list,"tu","vuong","manh");
        Collections.sort(list);
        for (int i=0;i<=list.size();i++){
            System.out.println(list.get(i)+" ,");
        }
        System.out.println();
        System.out.println("Vi tri thu "+Collections.binarySearch(list,"vuong"));
    }
}
