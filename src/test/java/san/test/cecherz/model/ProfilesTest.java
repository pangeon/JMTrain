package san.test.cecherz.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import san.jee.cecherz.dao.exception.UnknownRoleException;
import san.jee.cecherz.model.Profiles;
import san.jee.cecherz.model.Role;
import san.jee.cecherz.util.TokenProvider;


import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;


class ProfilesTest {
    Profiles p = new Profiles();

    @Test
    void setNewProfiles() {

        Timestamp time = new Timestamp(new Date().getTime());
        String token = new TokenProvider().getToken();

        p.setId(new BigInteger("1"));
        p.setEmail("pangeon@tlen.pl");
        p.setPassword("QWee123;");
        p.setIp("120.76.0.11");
        p.setToken(token);
        p.setReqstamp(time);
        p.setConfstamp(null);
        try {
            p.setRole(Role.attendee);
        } catch (UnknownRoleException e) {
            e.printStackTrace();
        }
        assertEquals(p.getId(), new BigInteger("1"));
        assertNotEquals(p.getId(), 1);
        assertEquals(p.getEmail(), "pangeon@tlen.pl");
        assertEquals(p.getPassword(), "QWee123;");
        assertEquals(p.getIp(), "120.76.0.11");
        assertEquals(p.getToken(), token);
        assertEquals(p.getReqstamp(), time);
        assertEquals(p.getConfstamp(), null);
        assertEquals(p.getRole(), Role.attendee.name());

        assertEquals(new Profiles(p), p);
        System.out.println(
                p.getId() + " " + p.getEmail() + " " +
                p.getPassword() + " " + p.getIp() + " " +
                p.getToken() + " " + p.getReqstamp() + " " +
                p.getConfstamp() + " " + p.getRole());
    }
}
