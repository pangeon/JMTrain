package san.jee.cecherz.model;

import san.jee.cecherz.dao.exception.UnknownRoleException;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

public class Profiles {
    private BigInteger id;
    private String email;
    private String password;
    private String ip;
    private String token;
    private Timestamp reqstamp;
    private Timestamp confstamp;
    private Role role;


    public Profiles() {};

    public Profiles(Profiles profile) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.ip = ip;
        this.token = token;
        this.reqstamp = reqstamp;
        this.confstamp = confstamp;
        this.role = role;
    }
    public BigInteger getId() {
        return id;
    }
    public void setId(BigInteger id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getReqstamp() {
        return reqstamp;
    }

    public void setReqstamp(Timestamp reqstamp) {
        this.reqstamp = reqstamp;
    }

    public Timestamp getConfstamp() {
        return confstamp;
    }

    public void setConfstamp(Timestamp confstamp) {
        this.confstamp = confstamp;
    }

    public void setRole(Role roleName) throws UnknownRoleException {
        switch (roleName.name()) {
            case "admin":
                role = Role.admin;
                break;
            case "trainer":
                role = Role.trainer;
                break;
            case "attendee":
                role = Role.attendee;
                break;
            default:
                role = null;
                throw new UnknownRoleException();
        }
    }
    public String getRole() {
        return role.name();
    }

    @Override
    public String toString() {
        return "Profiles{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ip='" + ip + '\'' +
                ", token='" + token + '\'' +
                ", reqstamp=" + reqstamp +
                ", confstamp=" + confstamp +
                ", role=" + role +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profiles profiles = (Profiles) o;
        return Objects.equals(id, profiles.id) &&
                Objects.equals(email, profiles.email) &&
                Objects.equals(password, profiles.password) &&
                Objects.equals(ip, profiles.ip) &&
                Objects.equals(token, profiles.token) &&
                Objects.equals(reqstamp, profiles.reqstamp) &&
                Objects.equals(confstamp, profiles.confstamp) &&
                role == profiles.role;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, ip, token, reqstamp, confstamp, role);
    }
}
