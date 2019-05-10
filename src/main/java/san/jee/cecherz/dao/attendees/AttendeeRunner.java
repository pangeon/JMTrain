package san.jee.cecherz.dao.attendees;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import san.jee.cecherz.dao.courses.CoursesRunner;
import san.jee.cecherz.model.Attendees;
import san.jee.cecherz.model.Courses;
import san.jee.cecherz.model.Profiles;
import san.jee.cecherz.util.ConnectionProvider;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendeeRunner implements AttendeeFactory {

    private static final String ADD_PROFILE_INFO =
            "INSERT INTO Attendees(idprof, name, surname, phone, city, postcode, street)" +
            "VALUES (:idprof, :name, :surname, :phone, :city, :postcode, :street)";

    private static final String SHOW_PROFILE_INFO =
            "SELECT name, surname, phone, city, postcode, street " +
            "FROM Attendees JOIN Profiles ON idprof = Profiles.id AND Profiles.id = idprof";

    private NamedParameterJdbcTemplate template;

    public AttendeeRunner() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
    }
    @Override
    public Attendees create(Attendees a) {
        Attendees a_result = new Attendees(a);
        KeyHolder kh = new GeneratedKeyHolder();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("idprof", a.getIdprof().getId());
        paramMap.put("name", a.getName());
        paramMap.put("surname", a.getSurname());
        paramMap.put("phone", a.getPhone());
        paramMap.put("city", a.getCity());
        paramMap.put("postcode", a.getPostcode());
        paramMap.put("street", a.getStreet());
        SqlParameterSource sps = new MapSqlParameterSource(paramMap);
        int update = template.update(ADD_PROFILE_INFO, sps, kh);
        if(update > 0) {
            a_result.setId((BigInteger) kh.getKey());
        }
        return a_result;

    }
    @Override
    public Attendees read(BigInteger PK) {
        return null;
    }

    @Override
    public boolean update(Attendees a_up) {
        return false;
    }

    @Override
    public boolean delete(BigInteger PK) {
        return false;
    }

    @Override
    public List<Attendees> getAll() {
        return null;
    }

    @Override
    public Attendees getProfileInfo(BigInteger FK) {
        return null;
    }

}
