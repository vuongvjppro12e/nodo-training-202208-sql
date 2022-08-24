import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDataEx {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs= null;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl","SCOTT","SCOTT");
            statement = connection.createStatement();
            rs = statement.executeQuery("select * from student_vct");

            while(rs.next()) {
                int id = rs.getInt("st_id");
                String name = rs.getString("st_name");
                int age = rs.getInt("st_age");
                System.out.println("id: " + id + ", Name: " + name + ", Age: " + age);
            }

            rs.close();
            statement.close();
            connection.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
