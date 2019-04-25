package san.jee.cecherz.model;

import java.math.BigInteger;
import java.util.Objects;

public class Profiles {
    private BigInteger id;
    private String email;
    private String password;
    private String roleName;
    private enum role {
        admin, trainer, attendee
    }

    public Profiles(BigInteger id, String email, String password, String roleName) {
        this.id = id;
        this.email = email;
        this.password = password;

        setRoleName(roleName);
        this.roleName = roleName;
    }

    private void setRoleName(String choiceRole) {
        switch (choiceRole) {
            case "admin":
                roleName = role.admin.name();
                break;
            case "trainer":
                roleName = role.trainer.name();
                break;
            case "attendee":
                roleName = role.attendee.name();
                break;
            default:
                roleName = "";
                break;
        }
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

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return "Profiles{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profiles profiles = (Profiles) o;
        return id.equals(profiles.id) &&
                email.equals(profiles.email) &&
                password.equals(profiles.password) &&
                roleName.equals(profiles.roleName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, roleName);
    }

}
