import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;

public class StudentJdbcDAO extends JdbcApp {
    private static Logger LOOGER;
    public DataSource dataSource;
    public JdbcTemplate jdbcTemplate;
    private String insertQuery;
    private String updateQuery;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private void createTableIfNotExist(){
        try {
            DatabaseMetaData dbmb = dataSource.getConnection().getMetaData();
            ResultSet rs = dbmb.getTables(null,null,"VTV_STUDENT",null);
            if (rs.next()){
                System.out.println("tables: "+rs.getString("TABLE_NAME")+"already exist !!");
                 return;
            }
            String sql = "create table VTV_STUDENT"
                    + "("
                    + "id int primary key ,"
                    + "name varchar(255),"
                    + "age int"
                    + ")";
//            jdbcTemplate.execute(sql); tạo bảng nếu chưa tồn tại
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void insert(int id, String name, int age){
        jdbcTemplate.update(insertQuery,id,name,age);
        System.out.println("Create Record Name = "+name+" Age = "+age+" id = "+id);
    }
    public void update(int id,String name,int age){
        jdbcTemplate.update(updateQuery,name,age,id);
        System.out.println("Update Record Name = "+name+" Age = "+age+" id = "+id);
    };
    public int totalRecord(){
     return jdbcTemplate.execute(new StatementCallback<Integer>() {
         @Override
         public Integer doInStatement(Statement stmt) throws SQLException, DataAccessException {
             ResultSet rs =stmt.executeQuery("select count(*) from VTV_STUDENT");
             return rs.next()?rs.getInt(1):0;
         }
     });
    }
    public void setInsertQuery(String insertQuery) {
        this.insertQuery = insertQuery;
    }

    public void setUpdateQuery(String updateQuery) {
        this.updateQuery = updateQuery;
    }

    private final static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student st = new Student();
            st.setId(rs.getInt("id"));
            st.setName(rs.getString("name"));
            st.setAge(rs.getInt("age"));
            return st;
        }
    }
    public List loadStudent(String name){
        StudentJdbcDAO studentJdbcDAO = new StudentJdbcDAO();
        return jdbcTemplate.query("select * from VTV_STUDENT where name like '%"+name+"%'",new StudentRowMapper());
    }
}
