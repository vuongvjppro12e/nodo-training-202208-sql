import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreMapEx {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(3,"Nguyen van A");
        map.put(1,"Nguyen van B");
        map.put(2,"Nguyen van C");
        map.put(4,"Nguyen van X");

        Iterator<Map.Entry<Integer,String>>iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String>entry = iterator.next();
            System.out.println("key = "+ entry.getKey()+"value "+ entry.getValue());
        }
    }
}
