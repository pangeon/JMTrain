package san.jee.cecherz.dao.courses;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import san.jee.cecherz.model.Courses;
import san.jee.cecherz.util.ConnectionProvider;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CoursesRunner implements CoursesFactory {

    private static final String COURSES_LIST_FOR_ATTENDEES =
            "SELECT id, title, start_date, end_date, description, max_attende " +
            "FROM Courses";

    private NamedParameterJdbcTemplate template;

    public CoursesRunner() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
    }

    @Override
    public Courses create(Courses newObject) {
        return null;
    }
    @Override
    public Courses read(BigInteger PK) {
        return null;
    }
    @Override
    public boolean update(Courses updateObject) {
        return false;
    }
    @Override
    public boolean delete(Courses key) {
        return false;
    }
    @Override
    public List<Courses> getAll() {
        List<Courses> coursesList = template.query(COURSES_LIST_FOR_ATTENDEES, new CoursesRowMapper());
        return coursesList;
    }
    private class CoursesRowMapper implements RowMapper<Courses> {

        @Override
        public Courses mapRow(ResultSet rs, int row) throws SQLException {
            Courses c = new Courses();
            c.setId(new BigInteger(Integer.valueOf(rs.getInt("id")).toString()));
            c.setTitle(rs.getString("title"));
            c.setStart_date(rs.getTimestamp("start_date"));
            c.setEnd_date(rs.getTimestamp("end_date"));
            c.setDescription(rs.getString("description"));
            c.setMax_attende(rs.getInt("max_attende"));
            return c;
        }
    }

}
