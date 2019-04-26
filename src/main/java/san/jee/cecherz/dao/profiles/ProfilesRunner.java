package san.jee.cecherz.dao.profiles;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import san.jee.cecherz.model.Profiles;
import san.jee.cecherz.util.ConnectionProvider;

import java.math.BigInteger;
import java.util.List;

public class ProfilesRunner implements ProfilesFactory {

    private static final String CREATE_PROFILE =
            "INSERT INTO Profiles(email, password, role) " +
                    "VALUES(:email, :password, :role);";

    private NamedParameterJdbcTemplate template;

    public ProfilesRunner() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
    }
    @Override
    public Profiles create(Profiles profile) {
        Profiles resultProfiles = new Profiles(profile);
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(profile);
        int update = template.update(CREATE_PROFILE, parameterSource, holder);
        if(update > 0) {
            resultProfiles.setId((BigInteger) holder.getKey());
        }
        return resultProfiles;
    }
    @Override
    public Profiles read(BigInteger primaryKey) {
        return null;
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
        return null;
    }
}
