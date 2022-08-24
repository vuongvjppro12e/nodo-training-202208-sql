
import java.sql.*;

public class DBFunction {
    public static void getAge( String name, int []ages) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT  max(st_age) from student_vct where name like '%"+name+"%' ");
            ages[0] = rs.next() ? rs.getInt(1) : -1;

        }finally {
            connection.close();
        }
    }

    public static void main(String[] args) throws SQLException {
        int[] ages = new int[1];
        getAge("Thi B",ages);
        System.out.println(ages[0]);
    }
}
