
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

public class StudentTest {

    public static List<Student>filer(List<Student>students, Filter pred){
        List list = new ArrayList();
        for (Student student:students){
            if (pred.equals(student)){
                list.add(student);
            }
        }
        return list;
    }

    public static void main(String[] args) {
       List students = new ArrayList<>();

       students.add(new Student("Viet Tien Vuong",20));
        students.add(new Student("hoang dieu huong",19));
        students.add(new Student("nguyen ngoc lan",21));
        students.add(new Student("pham hai yen",19));

        System.out.println(students);
    }
}
