package san.jee.cecherz.dao.profiles;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import san.jee.cecherz.dao.exception.UnknownRoleException;
import san.jee.cecherz.model.Profiles;
import san.jee.cecherz.model.Role;
import san.jee.cecherz.util.ConnectionProvider;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProfilesRunner implements ProfilesFactory {

    private static final String CREATE_PROFILE =
            "INSERT INTO Profiles(email, password, ip, token, role) " +
                          "VALUES(:email, :password, INET_ATON(:ip), :token, :role);";
    private static final String READ_PROFILE = "SELECT id, email, password, ip, token, regstamp, confstamp, role FROM Profiles WHERE id = :id";
    private static final String READ_ALL_PROFILES = "SELECT * FROM Profiles";
    private static final String READ_PROFILE_BY_EMAIL = "SELECT id, email, password, ip, token, regstamp, confstamp, role FROM Profiles WHERE email = :email";

    private NamedParameterJdbcTemplate template;

    public ProfilesRunner() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
    }
    @Override
    public Profiles create(Profiles p) {
        Profiles p_result = new Profiles(p);
        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource sps = new BeanPropertySqlParameterSource(p);
        int update = template.update(CREATE_PROFILE, sps, kh);
        if(update > 0) {
            p_result.setId((BigInteger) kh.getKey());
            setPrivigiles(p_result);
        }
        return p_result;
    }
    private void setPrivigiles(Profiles p) {
        final String query = "UPDATE Profiles SET role= :role WHERE email= :email";
        SqlParameterSource sps = new BeanPropertySqlParameterSource(p);
        template.update(query, sps);
    }
    //UPDATE Profiles SET role="attendee" WHERE email="bed46@wp.pl"
    /**
    read() wyszukuje użytkownika na podstawie jego id, PK tabeli Profiles.
    Tworzymy obiekt MapSqlParameterSource z przypisaniem wartości PK do id,
    następnie wstawione zostaną do zapytania READ_PROFILES.
    Do utworzenia wynikowego obiektu potrzebna jest klasa wewnętrzna ProfileRowMapper
    implementująca interfejs RowMapper. Posiada on jedną metodę mapRow(),
    w której tworzymy obiekt Profiles, ustawiamy jego kolejne pola poprzez settery.
    Wartości pobieramy z obiektu ResultSet, w którym do kolumn
    możemy odwoływać się po ich nazwach lub indeksach.

        -- analogicznie metoda getProfilesByEmail() --
     */
    @Override
    public Profiles read(BigInteger PK) {
        Profiles p_result = null;
        SqlParameterSource sps = new MapSqlParameterSource("id", PK);
        p_result = template.queryForObject(READ_PROFILE, sps, new ProfilesRowMapper());
        return p_result;
    }

    @Override
    public boolean update(Profiles updateObject) {
        return false;
    }

    @Override
    public boolean delete(BigInteger key) {
        return false;
    }

    @Override
    public List<Profiles> getAll() {
        List<Profiles> profilesList = template.query(READ_ALL_PROFILES, new ProfilesRowMapper());
        return profilesList;
    }
    @Override
    public Profiles getProfilesByEmail(String email) {
        Profiles p_result = null;
        SqlParameterSource sps = new MapSqlParameterSource("email", email);
        p_result = template.queryForObject(READ_PROFILE_BY_EMAIL, sps, new ProfilesRowMapper());
        return p_result;
    }

    private class ProfilesRowMapper implements RowMapper<Profiles> {
        @Override
        public Profiles mapRow(ResultSet rs, int i) throws SQLException {
            Profiles p = new Profiles();
            p.setId(new BigInteger(Integer.valueOf(rs.getInt("id")).toString()));
            p.setEmail(rs.getString("email"));
            p.setPassword(rs.getString("password"));
            p.setIp(rs.getString("ip"));
            p.setToken(rs.getString("token"));
            p.setRegstamp(rs.getTimestamp("regstamp"));
            p.setConfstamp(rs.getTimestamp("confstamp"));
            try {
                p.setRole(Role.valueOf(rs.getString("role")));
            } catch (UnknownRoleException e) {
                e.printStackTrace();
            }
            return p;
        }
    }
}
