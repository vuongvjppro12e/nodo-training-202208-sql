import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurrencyTest {
    public static void main(String[] args) {
        vd1();
        //text here
    }
    private static void vd3() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,3,4,2,3,6,3,3,8);
        System.out.println("Before remove: size of list = " + list.size());
        list.removeIf (item-> item == 3);


        System.out.println("After remove: size of list = " + list.size());
    }

    private static void vd2() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,3,4,2,3,6,3,3,8);
        System.out.println("Before remove: size of list =" + list.size());
        list.forEach(v -> {
            if (v == 3){
                list.remove(v);
            }
        });
        System.out.println("After remove: size of list = " + list.size());
    }

    private static void vd1() {
        List<Integer>  list = new ArrayList<>();
        Collections.addAll(list,new Integer[]{1,3,4,2,3,6,3,3,8});

        System.out.println("Before remove: size of list =" + list.size());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 3){
                list.remove(i);
            }
        }
        System.out.println("After remove: size of list = " + list.size());
    }
}
