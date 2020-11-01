package san.jee.cecherz.dao.subscribtions;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import san.jee.cecherz.model.Attendees;
import san.jee.cecherz.model.Courses;
import san.jee.cecherz.model.Subscriptions;
import san.jee.cecherz.model.Workplaces;
import san.jee.cecherz.util.ConnectionProvider;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubscribtionsRunner implements SubscribtionsFactory {

    // Zapytanie nie obsługuje tabeli Workplace - niezbędne modyfikacje
    private static final String ADD_SUBSCRIBTION = "INSERT INTO Subscribtions(id, idcour, idattend) " +
                                                    "VALUES (:id, :idcour, :idattend)";

    /*
    INSERT INTO Subscribtions(idcour, idattend) VALUES(2, 3) WHERE NOT EXISTS
    (SELECT * FROM Subscribtions WHERE idcour = :idcour AND idattend = :idattend);

    IF NOT EXISTS (SELECT idcour, idattend FROM Subscribtions WHERE idcour = :idcour AND idattend = :idattend)
    BEGIN
           INSERT INTO Subscribtions (idcour, idattend) VALUES (:idcour, :idattend)
    END;

    IF EXISTS (SELECT * FROM Profiles)
    BEGIN
           INSERT INTO Subscribtions (idcour, idattend) VALUES (1, 2)
    END;
     */

    private NamedParameterJdbcTemplate template;

    public SubscribtionsRunner() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
    }

    @Override
    // Metoda nie obsługuje tabeli Workplace - niezbędne modyfikacje
    public Subscriptions create(Subscriptions s) throws DuplicateKeyException {
            Subscriptions s_result = new Subscriptions(s);
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
    public Subscriptions read(BigInteger primaryKey) {
        return null;
    }
    @Override
    public boolean update(Subscriptions updateObject) {
        return false;
    }
    @Override
    public boolean delete(Subscriptions key) {
        return false;
    }
    @Override
    public List<Subscriptions> getAll() {
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
    public Workplaces getWorkplaceByFK(BigInteger ForeignKey) {
        return null;
    }
}
