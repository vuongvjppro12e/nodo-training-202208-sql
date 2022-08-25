import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;


public class JdbcApp2 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanx.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO)context.getBean("StudentJdbcDAO");
        System.out.println("created bean" +jdbc);
        Scanner scn = new Scanner(System.in);
        System.out.println("mời nhập tên: ...");
        String name = scn.nextLine();
        jdbc.loadStudent(name).forEach(st -> System.out.println(st.toString()));
    }
}
