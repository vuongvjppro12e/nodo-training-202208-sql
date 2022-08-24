import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        JdbcApp jdbc = (StudentJdbcDAO)context.getBean("StudentJdbcDAO");
        System.out.println("created bean" +jdbc);
    }
}
