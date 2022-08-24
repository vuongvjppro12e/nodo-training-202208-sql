
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDataEx {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl","SCOTT","SCOTT");
            statement = connection.createStatement();
            statement.execute("insert into student_vct(st_id,st_name, st_age) values(1,'vương vip boy', 22) ");
            statement.close();
            connection.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
