
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Filter;
import java.util.stream.Stream;

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

        //        chuong9.Filter<chuong9.Student> older = student -> student.getAge()>=30;
//        List<chuong9.Student> filtered = filter(students, older);
//        for(chuong9.Student student : filtered){
//            System.out.println(student);
//        }
//        filtered.forEach(student -> {
//            System.out.println(student);
//        });
//        Stream<chuong9.Student> stream = students.stream().filter(student -> student.getAge()>=30);
//        stream.forEach(student -> {
//            System.out.println(student);
//        });
//        Collections.sort(students,(chuong9.Student student1,chuong9.Student student2) -> student1.getAge() - student2.getAge());
//        students.forEach(student -> {
//            System.out.println(student);
//        });
//        Stream<chuong9.Student> stream = students.stream().sorted((chuong9.Student studen1, chuong9.Student student2) ->
//                studen1.getAge() - student2.getAge());
//        System.out.println(stream);

//        Comparator<Student> comparator = (Student student1, Student student2)-> student1.getAge() - student2.getAge();
//        Stream<Student> stream = students.stream().sorted(comparator);
//        stream.forEach(student ->
//                System.out.println(student));
//        System.out.println("\n Max is "+students.stream().max(comparator));
//        int sum = students.stream().mapToInt(Student::getAge).sum();
//        System.out.println("Average of age is "+sum/students.size());
//        students.parallelStream().forEach((it)->

        System.out.println(students);
    }
}
