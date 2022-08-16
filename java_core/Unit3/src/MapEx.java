import java.util.Hashtable;
import java.util.Map;

public class MapEx {
    public static void main(String[] args) {
        Map<Integer,String>map= new Hashtable<Integer,String>();
        map.put(3,"Nguyen van A");
        map.put(1,"Nguyen van B");
        map.put(2,"Nguyen van C");
        map.put(4,"Nguyen van X");
        System.out.println(map.get(3));
        map.put(3,"Nguyen thi A");
        System.out.println(map.get(3));
    }
}
