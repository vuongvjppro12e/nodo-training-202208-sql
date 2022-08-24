import java.sql.*;

public class BatchProcessingEx {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        String url = "jdbc:oracle:thin:@27.118.22.14:1521:orcl";
        try {
            connection = DriverManager.getConnection(url, "SCOTT", "SCOTT");
            statement = connection.createStatement();
            String sql;
            connection.setAutoCommit(false);
            for(int i = 0; i < 10; i++) {
                int id = 5 + i;
                String name = "Kien" + i;
                int age = 20 + i;
                sql = "insert into student_vct(st_id,st_name, st_age)" +
                        "values("+ id + "," + name + ", " + age +  ")";
//            statement.addBatch(sql);
//            System.out.println(sql);
                statement.execute(sql);
            }
//        statement.executeBatch();
            ResultSet rs = statement.executeQuery("select  count(*) from student_vct");
            if(rs.next()) {
                System.out.println("total record: " + rs.getInt(1));
                statement.close();
                connection.close();
            }

        }catch (Exception e) {
            System.out.println("------------");
            e.printStackTrace();
        }
    }
}
