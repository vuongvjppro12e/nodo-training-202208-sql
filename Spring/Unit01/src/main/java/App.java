import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Object obj = (HelloClazz)context.getBean("helloJavaClazz");
        System.out.println(obj);
    }
}
