import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class StudentJdbcDAO extends JdbcApp {
    private static Logger LOOGER;
    public DataSource dataSource;
    public JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private void createTableIfNotExist(){
        try {
            DatabaseMetaData dbmb = dataSource.getConnection().getMetaData();
            ResultSet rs = dbmb.getTables(null,null,"STUDENT",null);
            if (rs.next()){
                System.out.println("tables: "+rs.getString("TABLE_NAME")+"already exist !!");
                 return;
            }
            jdbcTemplate.execute("create table student (id   bigint primary key generated always as identity (start with 1, increment by 1),  name varchar(1000), age  integer)");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
