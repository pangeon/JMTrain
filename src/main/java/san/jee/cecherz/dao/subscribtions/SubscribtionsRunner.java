package san.jee.cecherz.dao.subscribtions;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import san.jee.cecherz.model.Attendees;
import san.jee.cecherz.model.Courses;
import san.jee.cecherz.model.Subscribtions;
import san.jee.cecherz.model.Workplace;
import san.jee.cecherz.util.ConnectionProvider;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubscribtionsRunner implements SubscribtionsFactory {

    // Zapytanie nie obsługuje tabeli Workplace - niezbędne modyfikacje
    private static final String ADD_SUBSCRIBTION = "INSERT INTO Subscribtions(id, idcour, idattend) " +
                                                    "VALUES (:id, :idcour, :idattend)";

    private NamedParameterJdbcTemplate template;

    public SubscribtionsRunner() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
    }

    @Override
    // Metoda nie obsługuje tabeli Workplace - niezbędne modyfikacje
    public Subscribtions create(Subscribtions s) {
        Subscribtions s_result  = new Subscribtions(s);
        KeyHolder kh = new GeneratedKeyHolder();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", s.getId());
        paramMap.put("idcour", s.getCourse().getId());
        //paramMap.put("idworkpl", s.getWorkplace().getId());
        paramMap.put("idattend", s.getAttendee().getId());
        SqlParameterSource sps = new MapSqlParameterSource(paramMap);
        int update = template.update(ADD_SUBSCRIBTION, sps, kh);
        if (update > 0) {
            s_result.setId((BigInteger) kh.getKey());
        }
        return s_result;
    }
    @Override
    public Subscribtions read(BigInteger primaryKey) {
        return null;
    }
    @Override
    public boolean update(Subscribtions updateObject) {
        return false;
    }
    @Override
    public boolean delete(Subscribtions key) {
        return false;
    }
    @Override
    public List<Subscribtions> getAll() {
        return null;
    }
    @Override
    public Attendees getAttendeeByFK(BigInteger ForeignKey) {
        return null;
    }
    @Override
    public Courses getCourseByFK(BigInteger ForeignKey) {
        return null;
    }
    @Override
    public Workplace getWorkplaceByFK(BigInteger ForeignKey) {
        return null;
    }
}
