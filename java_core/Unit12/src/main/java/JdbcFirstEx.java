
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcFirstEx {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
           connection = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl","SCOTT","SCOTT");
           statement = connection.createStatement();
           String sql ="CREATE TABLE VTV_STUDENT \n" +
                   "(\n" +
                   "  ID NUMBER NOT NULL \n" +
                   ", NAME VARCHAR2(20) \n" +
                   ", AGE NUMBER \n" +
                   ", CONSTRAINT STUDENT_PK PRIMARY KEY \n" +
                   "  (\n" +
                   "    ID \n" +
                   "  )\n" +
                   "  USING INDEX \n" +
                   "  (\n" +
                   "      CREATE UNIQUE INDEX STUDENT_PK1 ON VTV_STUDENT (ID ASC) \n" +
                   "  )\n" +
                   "  ENABLE \n" +
                   ");";
            System.out.println("create sucess");
            System.out.println(statement.execute(sql));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
