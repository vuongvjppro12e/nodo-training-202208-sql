import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.RowSetProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DataFiler implements Predicate {
    @Override
    public boolean evaluate(RowSet rs) {
        CachedRowSet crs = (CachedRowSet) rs;
        try {
            return crs.getString("name").indexOf("vuong") > -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean evaluate(Object value, int column) throws SQLException {
        return false;
    }

    @Override
    public boolean evaluate(Object value, String columnName) throws SQLException {
        return false;
    }
}
