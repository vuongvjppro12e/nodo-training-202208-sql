
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcFirstEx {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
           connection = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl","SCOTT","SCOTT");
           statement = connection.createStatement();
            String sql  = "create table student_vct (\n" +
                    "    st_id number primary key," +
                    "    st_name varchar(50)," +
                    "    st_age int " +
                    ")";

            System.out.println("create sucess");
            System.out.println(statement.execute(sql));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            statement.close();
            connection.close();
        }
    }
}
