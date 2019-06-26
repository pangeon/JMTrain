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
    private Timestamp regstamp;
    private Timestamp confstamp;
    private Role role;
    private int active;


    public Profiles() {};

    public Profiles(Profiles profile) {
        this.id = profile.id;
        this.email = profile.email;
        this.password = profile.password;
        this.ip = profile.ip;
        this.token = profile.token;
        this.regstamp = profile.regstamp;
        this.confstamp = profile.confstamp;
        this.role = profile.role;
        this.active = profile.active;
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

    public Timestamp getRegstamp() {
        return regstamp;
    }

    public void setRegstamp(Timestamp regstamp) {
        this.regstamp = regstamp;
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
    @Override
    public String toString() {
        return "Profiles{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ip='" + ip + '\'' +
                ", token='" + token + '\'' +
                ", regstamp=" + regstamp +
                ", confstamp=" + confstamp +
                ", role=" + role +
                ", active=" + active +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profiles profiles = (Profiles) o;
        return active == profiles.active &&
                Objects.equals(id, profiles.id) &&
                Objects.equals(email, profiles.email) &&
                Objects.equals(password, profiles.password) &&
                Objects.equals(ip, profiles.ip) &&
                Objects.equals(token, profiles.token) &&
                Objects.equals(regstamp, profiles.regstamp) &&
                Objects.equals(confstamp, profiles.confstamp) &&
                role == profiles.role;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, ip, token, regstamp, confstamp, role, active);
    }
}
