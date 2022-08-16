import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        for (String ele:args){
            list.add(ele);

        }
        Iterator<String> iterrator = list.iterator();
        while(iterrator.hasNext()){
            System.out.println("===>" +iterrator.next());
        }
    }
}
