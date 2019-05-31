package san.jee.cecherz.dao.attendees;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
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

    private static final String SHOW_ALL_PROFILES_INFO =
            "SELECT Attendees.id, Attendees.idprof, Attendees.name, Attendees.surname, Attendees.phone, Attendees.city, Attendees.postcode, Attendees.street " +
            "FROM Attendees INNER JOIN Profiles " +
            "ON Attendees.idprof = Profiles.id";

    private static final String SHOW_ONE_PROFILE_INFO =
            "SELECT id, idprof, name, surname, phone, city, postcode, street " +
            "FROM Attendees WHERE idprof = :idprof";

    private NamedParameterJdbcTemplate template;

    public AttendeeRunner() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
    }
    @Override
    public Attendees create(Attendees a) {
        Attendees a_result = new Attendees(a);
        KeyHolder kh = new GeneratedKeyHolder();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", a.getId());
        paramMap.put("idprof", a.getProfiles().getId());
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
    public Attendees read(BigInteger FK) {
        try {
            Attendees a_result = null;
            SqlParameterSource sps = new MapSqlParameterSource("idprof", FK);
            a_result = template.queryForObject(SHOW_ONE_PROFILE_INFO, sps, new AttendeeRowMapper());
            return a_result;
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Ten użytkownik nie zawiera jeszcze danych osobowych.");
            return null;
        }

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
        List<Attendees> attendeesList = template.query(SHOW_ALL_PROFILES_INFO, new AttendeeRowMapper());
        return attendeesList;
    }

    @Override
    public Attendees getProfileInfo(BigInteger FK) {
        return null;
    }

    private class AttendeeRowMapper implements RowMapper<Attendees> {

        @Override
        public Attendees mapRow(ResultSet rs, int i) throws SQLException {
            Attendees attendeesList = new Attendees();
            attendeesList.setId(new BigInteger(Integer.valueOf(rs.getInt("id")).toString()));
            attendeesList.setIdprof(new BigInteger(Integer.valueOf(rs.getInt("idprof")).toString()));
            attendeesList.setName(rs.getString("name"));
            attendeesList.setSurname(rs.getString("surname"));
            attendeesList.setPhone(rs.getString("phone"));
            attendeesList.setCity(rs.getString("city"));
            attendeesList.setPostcode(rs.getString("postcode"));
            attendeesList.setStreet(rs.getString("street"));
            return attendeesList;
        }
    }
}
