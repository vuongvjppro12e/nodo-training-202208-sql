import org.springframework.context.support.ClassPathXmlApplicationContext;
public class JdbcApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanx.xml");
        JdbcApp jdbc = (StudentJdbcDAO)context.getBean("StudentJdbcDAO");
        System.out.println("created bean" +jdbc);
        StudentJdbcDAO jdbcDAO = (StudentJdbcDAO)context.getBean("StudentJdbcDAO");
//        jdbcDAO.insert(4,"vinh ",19); //thêm bản ghi phải sửa id
//        System.out.println("Total student is "+jdbcDAO.totalRecord());
        jdbcDAO.update(4,"kien",16);
    }
}
